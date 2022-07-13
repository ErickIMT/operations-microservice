package com.nttdata.operations.application.configuration;

import com.nttdata.operations.domain.dto.Customer;
import com.nttdata.operations.infrastructure.entity.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class RedisConfiguration {
/*
  @Bean
  public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
    return new LettuceConnectionFactory("localhost", 6378);
  }*/

  @Bean
  public ReactiveRedisOperations<String, Operation> reactiveRedisOperations(ReactiveRedisConnectionFactory factory) {
    return new ReactiveRedisTemplate<String, Operation>(factory,
      RedisSerializationContext.fromSerializer(new Jackson2JsonRedisSerializer(Operation.class)));
  }
}
