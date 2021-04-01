import os, sys
from flask import Flask,   json

app = Flask(__name__)

@app.route('/', methods=['GET'])
def get_method():

        status=200

        response = app.response_class(
            response=json.dumps({'status':'OK'}),
            status=status,
            mimetype='application/json'
        )        
        return response
app.run(host='0.0.0.0', port=8088, debug=True)