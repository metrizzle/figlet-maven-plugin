#!/usr/bin/env python
#-*- encoding: utf-8 -*-

"""
pkg_resources Mock Impl
"""


import sys
from com.github.maven.plugins import JyPkgResourceStub
  
def resource_exists(package_or_requirement, resource_name):
    return JyPkgResourceStub.resourceExists(package_or_requirement, resource_name)

def resource_string(package_or_requirement, resource_name):
    """Return specified resource as a string"""
    resource = JyPkgResourceStub.resolveResource(package_or_requirement, resource_name)
    return resource
