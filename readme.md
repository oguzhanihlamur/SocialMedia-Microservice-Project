# Notlar

## Docker Image larını Eklemek

    MongoDB
    userName: admin
    password: root
    DB: UserProfileDB
``` bash
docker run -d --name mongodb -p 27017:27017 muhammedali55/mongodb:v.0.3
```

    mongod: 
    db.createUser({user: "antozy",pwd: "root",roles: ["readWrite","dbAdmin"]})


## Docker üzerinde Redis Single Node oluşturmak

```bash
    docker run --name microservice-redis -p 6379:6379 -d redis
```

```bash
    docker run  --name redis-gui -d -p 8001:8001 redislabs/redisinsight:1.14.0
```

## Redis Spring Boot Configuration
    İlgili bağımlılık eklenir.

    implementation 'org.springframework.boot:spring-boot-starter-data-redis:3.2.2'

    DİKKAT!!!!
    Redis repository olarak kullanılabileceği gibi, Cache olarakta kullanılabilir, Bu nedenle Spring te Cache i 
    ve Redis Repostory aktif etmek için gerekli annotasyonları config e eklemeniz uygun olacaktır.

```java
@Configuration
@EnableRedisRepositories
@EnableCaching
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

}
```

## Dockerfile ile image oluşturmak

    DİKKAT !!!
    localde çalıştırılacak ise aşağıdaki image komutu kullanılabilir.

```bash
docker build -t configserver:v250101 .
```

    DockerHub üzerinde yayınlanacak ve Cloud a atılacak ise 

```bash
docker build -t aantozy/configserver:v250101 .
```

    M Çipli bir MacOS var ise 

```bash
docker build --platform linux/amd64 -t aantozy/egitimconfigserver:v250101 .

docker build --platform linux/amd64 -t aantozy/egitimauthmicroservice:v250101 .

docker build --platform linux/amd64 -t aantozy/egitimusermicroservice:v250101 .
```