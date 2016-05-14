#!/usr/bin/env python
#-*- encoding: utf-8 -*-

"""
pkg_resources Mock Impl
"""


import sys
from com.github.maven.plugins import FontResources
  
def resource_exists(package_or_requirement, resource_name):
    return FontResources.resourceExists(package_or_requirement, resource_name)

def resource_string(package_or_requirement, resource_name):
    """Return specified resource as a string"""
    resource = FontResources.resolveResource(package_or_requirement, resource_name)
    return resource
