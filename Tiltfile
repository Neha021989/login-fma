load('ext://helm_remote', 'helm_remote')
helm_remote('mongodb',
            repo_name='stable',
            repo_url='https://charts.helm.sh/stable')
            
### working without issues  
#local_resource(
#  'login-fma-jib-build',
#  'mvn -f ./pom.xml compile jib:build -D image=nechoudhary/login-fma',
#  deps=['./pom.xml', './target/classes'])

## Causing issues via building the image
custom_build(
  'nechoudhary/login-fma',
  'mvn -f pom.xml compile jib:build -D image=$EXPECTED_REF',
  skips_local_docker=True,
  deps=['./target/classes'],
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
