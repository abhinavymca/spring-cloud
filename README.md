# spring-cloud

Port table:

| App                   | Port  |
|-----------------------|-------|
| user-ms               | 8000  |
| booking-ms            | 8100  |
| config-server         | 8888  |
| netflix-eureka-server | 8761  |
| api-gateway           | 8765  |

```bash
gcloud container --project "burner-abhgarg6-02" clusters create-auto "autopilot-cluster-1" \
--region "us-central1" --release-channel "regular" --network "projects/burner-abhgarg6-02/global/networks/default" \
--subnetwork "projects/burner-abhgarg6-02/regions/us-central1/subnetworks/default" \
--cluster-ipv4-cidr "/17"

../gradlew clean build bootjar
docker build -t abhinavymca/user-ms .
docker push abhinavymca/user-ms
helm upgrade --install user-ms -f helm/values.yaml ../helm-charts/ms-charts

docker build -t abhinavymca/api-gateway .
docker push abhinavymca/api-gateway
helm upgrade --install api-gateway -f helm/values.yaml ../helm-charts/ms-charts

docker build -t abhinavymca/netflix-eureka-server .
docker push abhinavymca/netflix-eureka-server
helm upgrade --install netflix-eureka-server -f helm/values.yaml ../helm-charts/ms-charts

docker build -t abhinavymca/config-server .
docker push abhinavymca/config-server
helm upgrade --install config-server -f helm/values.yaml ../helm-charts/ms-charts

```
