load('ext://helm_remote', 'helm_remote')
helm_remote('mongodb',
            repo_name='stable',
            repo_url='https://charts.helm.sh/stable')

login_yaml = helm(
  './helm',
  # The release name, equivalent to helm --name
  name='login-fma',
  # The namespace to install in, equivalent to helm --namespace
  namespace='default',
  # The values file to substitute into the chart.
  values=['./helm/values.yaml'],
  # Values to set from the command-line
  set=['service.port=8080', 'ingress.enabled=true']
  )
k8s_yaml(login_yaml)

enquiries_yaml = helm(
  '../enquiries-fma/helm',
  # The release name, equivalent to helm --name
  name='enquiries-fma',
  # The namespace to install in, equivalent to helm --namespace
  namespace='default',
  # The values file to substitute into the chart.
  values=['../enquiries-fma/helm/values.yaml'],
  # Values to set from the command-line
  set=['service.port=8082', 'ingress.enabled=true']
  )
k8s_yaml(enquiries_yaml)
