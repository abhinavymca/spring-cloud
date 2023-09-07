# spring-cloud

Port table:

| App                    | Port |
|------------------------|------|
| user-ms                | 8000 |
| booking-ms             | 8100 |
| config-server          | 8888 |
| /netflix-eureka-server | 8761 |

```bash
../gradlew clean build bootjar
docker build -t abhinavymca/user-ms .
docker push abhinavymca/user-ms
helm upgrade --install user-ms --set ms.image.repository=abhinavymca/user-ms --set ms.port=8000 ../helm-charts/ms-charts

docker build -t abhinavymca/api-gateway .
docker push abhinavymca/api-gateway
helm upgrade --install api-gateway --set ms.image.repository=abhinavymca/api-gateway --set ms.port=8765 ../helm-charts/ms-charts

docker build -t abhinavymca/netflix-eureka-server .
docker push abhinavymca/netflix-eureka-server
helm upgrade --install netflix-eureka-server --set ms.image.repository=abhinavymca/netflix-eureka-server --set ms.port=8761 ../helm-charts/ms-charts
```
