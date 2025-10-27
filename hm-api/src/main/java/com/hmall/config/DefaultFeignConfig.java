package com.hmall.config;

import com.hmall.common.utils.UserContext;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfig {
   @Bean
   public Logger.Level feignLoggerLevel(){
      return Logger.Level.FULL;
   }
   @Bean
   public RequestInterceptor userInfoRequestInterceptor() {
      return new RequestInterceptor() {
         @Override
         public void apply(RequestTemplate template) {
            Long userId = UserContext.getUser();
            if (userId != null) {
               template.header("name", "user-info", userId.toString());
            }
         }
      };
   }

}
