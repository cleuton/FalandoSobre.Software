import yaml
import rsa
import logging

def load_config():
    stream = open("server/server_config.yaml", "r")
    config = yaml.safe_load(stream)
    logging.basicConfig(filename=config["logfile"], level=config["loglevel"])
    return config

