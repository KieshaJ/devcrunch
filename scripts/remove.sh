#!/bin/sh
cd ../dc-back-end/ && echo y | docker rmi $(docker images -q);