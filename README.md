## Prerequisites

### Install docker, kubectl, and set up a cluster

Running from a windows machine, I personally used Docker Desktop which comes with docker and Minikube which comes with kubectl and allows me to create a cluster.

### Install helm

* https://github.com/helm/helm/releases/tag/v3.6.0
* Scroll down where it says "Installing and Upgrading" and you can install it

## Create image & store in DockerHub
* `mvn package` // Generates jar in target folder
* `docker build -t tonyaficken/helm-test-app:1.0.0 .` // Build image using Dockerfile
* Optional: To test running image in docker:
  ```
   // Feature of docker is security. tcp port is not accessible outside docker container. p is for publish or redirect. could be 8081:8081
   docker run -it --rm --name helm-test-app-cntr -p 8082:8081 tonyaficken/helm-test-app:1.24.
  ```
  * Can then access the app via http://localhost:8082/hi
* `docker login` // Login to dockerhub
* `docker push tonyaficken/helm-test-app:1.0.0` // Push to dockerhub

## Install & Run
* `minikube start` // Create the cluster
* `helm create helm-demo` // Create helm chart
*  Delete everything but Chart.yaml file in the helm chart. Add deployment.yaml and service.yaml into helm-demo/templates directory
* `helm install helm-test-app ./helm-demo` // Install using helm chart
* `minikube service helm-test-app` // Access the application in a browser

## Basic Helm Commands
#### Create Helm Chart
* `helm create helm-demo`

### Install / Update
* `helm install helm-test-app ./helm`
* `helm upgrade helm-test-app ./helm`
* Optional params
  * `--set imag.tag=1.22.0,replicaCount=2`
  * `--debug` // Print verbose output - includes manifest file
  * `--dry-run` // Test your helm install without actually doing the install
  * `--values ./helm-demo/values-dev.yaml` // Use custom values file. Same as `-f`
  * `--help` // list all the available flags
  * `--wait --timeout x` // waits for all pods to be up and running 
### Get
* `helm ls` // Same as list
* `helm get values helm-test-app` // Get values initialized with --values or --set
* `helm get manifest helm-test-app` // Get the rendered yaml file
* `helm history helm-test-app` // See revision history

### Delete / Rollback
* `helm delete helm-test-app`
  * Same as `helm uninstall helm-test-app`
* `helm rollback helm-test-app`
* `helm get values helm-test-app`

### More
* `helm package helm`
