from flask import Flask
from server.config import config_loader
from business import business_layer
from business.factories.concrete.concrete_factory import ConcreteFactory
from business.abstract_strategy import AbstractStrategy
import logging
from flask_httpauth import HTTPBasicAuth
from werkzeug.security import generate_password_hash, check_password_hash
import concurrent.futures
import json

###############
# Configuration
###############

config = config_loader.load_config()

logging.info("Servidor escutando na porta: " + str(config.get("port")))
logging.info("Servidor escutando na porta: " + config.get("strategy"))
logging.info("Servidor escutando na porta: " + str(config.get("public_key")))
logging.info("Servidor escutando na porta: " + str(config.get("max_threads")))

poolx = concurrent.futures.ThreadPoolExecutor(max_workers=config.get('max_threads'))

app = Flask(__name__)
auth = HTTPBasicAuth()

#
# Fake users for now... We may have to fetch tem from a database
#

users = {
    "john": generate_password_hash("hello"),
    "Aladdin": generate_password_hash("open sesame")
}


factory = ConcreteFactory()

########
# Hooks
########

@auth.verify_password
def verify_password(username, password):
    if username in users and \
            check_password_hash(users.get(username), password):
        return username


@app.route('/token', methods=['POST'])
@auth.login_required
def ask_token():
    result = {}
    result["token"] = business_layer.start_calc(factory,auth.current_user(),poolx)
    return json.dumps(result)

@app.route('/token_result', methods=['GET'])
@auth.login_required
def get_result():
    result = {}
    result["token"] = business_layer.return_token(auth.current_user())
    return json.dumps(result)

##########
# Startup
##########

if __name__ == "__main__":
    app.run(port=config.get("port"))