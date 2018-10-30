#!/usr/bin/env groovy

def jenkinsfile
def version = 'master'

fileLoader.withGit('https://github.com/nylend95/common-jenkinsfiles.git', '', null, ''){
  jenkinsfile = fileLoader.load('vars/pipe');
}

def overrides = [
      sayDuringCompile:'Compiling',
      sayDuringTests:'Testing'
      ]

jenkinsfile(overrides)
