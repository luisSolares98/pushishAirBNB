#!/bin/bash
hostname=$(curl http://169.254.169.254/metadata/v1/hostname)
docker run -d -p 8080:8080 --name publish-"$hostname" luissolares98/mspublish:"$hostname"