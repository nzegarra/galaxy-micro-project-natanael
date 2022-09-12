package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.cache;

import java.net.UnknownHostException;
import java.time.Duration;
 
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

import pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.document.Treatment;
 
@Configuration
public class TreatmentRedisConfig {
 
	  @Bean
	  public RedisTemplate<Object, Treatment> movRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
	        RedisTemplate<Object, Treatment> template = new RedisTemplate();
	        template.setConnectionFactory(redisConnectionFactory);
	        
	         // serializador
	        Jackson2JsonRedisSerializer<Treatment> ser = new Jackson2JsonRedisSerializer<Treatment>(Treatment.class);
	        template.setDefaultSerializer(ser);
	        return template;
	    }
	    
	
	  @Bean
	    public RedisCacheConfiguration cacheConfiguration() {
	        return RedisCacheConfiguration.defaultCacheConfig()
	          .entryTtl(Duration.ofMinutes(1))
	          .disableCachingNullValues()
	          .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	    }
	  
	  @Bean
	    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
	        return (builder) -> builder
	        .withCacheConfiguration("treatment",
	            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(15)));      
	    }   
	   
}
