load('ext://helm_remote', 'helm_remote')
load('ext://global_vars', 'get_global', 'set_global')
helm_remote('mongodb',
            repo_name='stable',
            repo_url='https://charts.helm.sh/stable')

local_resource(
  'login-fma-jib-build',
  'mvn clean compile jib:build',
  deps=['src', 'pom.xml'])

## Causing issues via building the image
custom_build(
  'nechoudhary/login-fma',
  'mvn -f ./pom.xml clean compile jib:build -D --image=$EXPECTED_REF',
  deps=['./pom.xml', './target/classes'],
  tag='latest',
  live_update = [
  sync('./target/classes', '/workspace/BOOT-INF/classes')
  ])


login_yaml = helm(
  './helm',
  name='login-fma',
  namespace='default',
  values=['./helm/values.yaml'],
  set=['ingress.enabled=true']
  )
k8s_yaml(login_yaml)

k8s_resource(workload='login-fma', port_forwards=8083)
