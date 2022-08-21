package com.springboot.musicplayer;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication()
@EnableMongoRepositories
public class MusicPlayerApplication {

//	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//			"cloud_name", "dungtd",
//			"api_key", "553685374214836",
//			"api_secret", "QLOlTiPPPESG9iyQhzG634GfhBQ"));

	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "thinhdoan",
			"api_key", "569619334749385",
			"api_secret", "8CbnmvFxpik9YbuZo3GgsO7x5y8"));

	public static void main(String[] args) {
		SpringApplication.run(MusicPlayerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
			}
		};
	}

	@Bean
	public MongoClient mongodb() {
		ConnectionString connectionString = new ConnectionString("mongodb+srv://doangiathinh:XuJhCFggLA5ppx1X@cluster0.iqbvy.mongodb.net/?retryWrites=true&w=majority");
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

//	@Bean
//	public MongoTemplate mongoTemplate() {
//		return new MongoTemplate(mongodb(), "springify");
//	}
@Bean
public MongoTemplate mongoTemplate() {
	return new MongoTemplate(mongodb(), "MusicPlayer");
}
}

