Create image on local environment:
docker build -t cyclingchat-image:1.0 .

To push images to the docker hub it's necessary to:
* docker login -u brunocoelho1997 -p password
* docker push brunocoelho1997/cyclingchat-image:1.0

Access deployment through the service:
* kubectl apply -f k8/deployment.yaml
* kubectl apply -f k8/service.yaml
* minikube service --url cyclingchat-service
* wait 1m


Access deployment through the ingress:
* kubectl apply -f k8/deployment.yaml
* kubectl apply -f k8/service.yaml
* kubectl apply -f k8/ingress.yaml
* wait 1m
* access the deployment with the created ip by ingress (k9s to see the address listed on the ingress)


How to access the API:
* Apply the service.yaml
* List services
* Get the Cluster-ip from the cyclingchat-service



Access h2-console memory database:
* http://localhost:8080/h2-console/

Fonts:
* https://kubernetes.io/docs/concepts/services-networking/service/
* https://minikube.sigs.k8s.io/docs/handbook/accessing/