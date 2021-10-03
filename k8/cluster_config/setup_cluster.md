In order to use a old machine with 2gb RAM and 320GB HDD was created a K8 Cluster with Kubeadm

Setup fonts:
* https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/
* https://www.densify.com/kubernetes-tools/kubeadm


On master:
* sudo apt-get install -y apt-transport-https ca-certificates curl
* sudo curl -fsSLo /usr/share/keyrings/kubernetes-archive-keyring.gpg https://packages.cloud.google.com/apt/doc/apt-key.gpg
* echo "deb [signed-by=/usr/share/keyrings/kubernetes-archive-keyring.gpg] https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee /etc/apt/sources.list.d/kubernetes.list
* sudo apt-get update
* sudo apt-get install -y kubelet=1.14.5-00 kubeadm=1.14.5-00 kubectl=1.14.5-00
* sudo apt-mark hold kubelet kubeadm kubectl
* disable swap: sudo swapoff -a
* sudo kubeadm init --pod-network-cidr=10.244.0.0/16
* follow the instructions listed on the command
  * The command printed: kubeadm join 192.168.1.91:6443 --token 4dibir.scpjap5nn3igjt63 --discovery-token-ca-cert-hash sha256:3a15755b61ecb5160500bfd0dc83d4343cf03a4a928a518619c019d0985a0f6a
  * mkdir -p $HOME/.kube 
  * sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config 
  * sudo chown $(id -u):$(id -g) $HOME/.kube/config
  * 

on slave:
* disable swap: sudo swapoff -a
* kubeadm join 192.168.1.91:6443 --token 4dibir.scpjap5nn3igjt63 --discovery-token-ca-cert-hash sha256:3a15755b61ecb5160500bfd0dc83d4343cf03a4a928a518619c019d0985a0f6a


Set up Networking for the Cluster
* on all computers run: 
  * echo "net.bridge.bridge-nf-call-iptables=1" |
  * sudo tee -a /etc/sysctl.conf
  * sudo sysctl -p
* on master node rum:
  * kubectl apply -f /home/bscoelho/workspace/K8Course/cycling-chat-k8/k8/cluster_config/kube-flannel.yml
* wait a few seconds and all nodes should have the status "Ready"
  * kubectl get nodes
