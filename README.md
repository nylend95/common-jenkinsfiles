# common-jenkinsfiles

This repository is used to host a basic example of a Jenkins pipeline in groovy.
The pipeline can be used by any other project which uses Jenkins as a CI/CD-tool.

## Usage
Jenkins-plugin installed: [Pipeline Remote Loader Plugin](https://github.com/jenkinsci/workflow-remote-loader-plugin)

Load this repo and load the [file](https://github.com/nylend95/common-jenkinsfiles/blob/master/vars/pipe.groovy) with:

```
def jenkinsfile
fileLoader.withGit('https://github.com/nylend95/common-jenkinsfiles.git', '', null, ''){
  jenkinsfile = fileLoader.load('vars/pipe');
}
```

The loaded file takes in a Map of overrides. This can be used to change settings (in this example, just basic printing of variables) specific to your project. Only keys specified in the loaded file are able to be overwritten.

```
def overrides = [:]

jenkinsfile(overrides)
```

[pipe.groovy](/vars/pipe.groovy) is subject to change and is only an example.
This [Jenkinsfile](Jenkinsfile) is an example of a Jenkinsfile.
