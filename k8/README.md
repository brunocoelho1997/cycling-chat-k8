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



Fonts:
* https://kubernetes.io/docs/concepts/services-networking/service/
* https://minikube.sigs.k8s.io/docs/handbook/accessing/