#Notes

## Create docker image
Create image on local environment:
* docker build -t cyclingchat-image:1.0 .

## Old deployment (without helm)
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


## New deployment (with helm)
Postgresql
* was created the persistent volume (PV)
* was created the persistent volume claim (PVC)
* was initialized the helm chart with:
  * helm upgrade --install -f k8/postgresql/my-values.yaml postgresql k8/postgresql/

cycling-chat-helm
* helm upgrade --install -f k8/cycling-chat-helm/my-values.yaml cycling-chat k8/cycling-chat-helm/

## Rabbit

To access the rabbitmq admin panel it's necessary:
* port forward with k9s to rabbitmq/amqp:15672
* go to the link: http://localhost:5672/

To point the api to the rabbit:
* use host from rabbits service -> get cluster-ip

##Fonts:
* https://kubernetes.io/docs/concepts/services-networking/service/
* https://minikube.sigs.k8s.io/docs/handbook/accessing/