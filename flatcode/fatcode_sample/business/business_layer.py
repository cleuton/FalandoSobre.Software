from business.factories.abstract_strategy_factory import AbstractFactory
from business import abstract_strategy
import concurrent.futures
import threading


class Results:
    results={}
    def __init__(self):
        self.lock = threading.Lock()
    def addResult(self,name):
        with self.lock:
            self.results[name]={}
            self.results[name]['token']=-1
    def updateResult(self,name,token):
        with self.lock:
            self.results[name]['token']=token

    def removeResult(self,name):
        with self.lock:
            del self.results[name]

results_group = Results()

def set_result(future):
    global results
    result = future.result()
    results_group.updateResult(result['name'],result['token'])
    

def start_calc (factory: AbstractFactory, name, poolx):
    strategy = factory.create_calc_strategy()
    results_group.addResult(name)
    future=poolx.submit(strategy.calculate,name)
    future.add_done_callback(set_result)
    result = {'future':future}
    return "wait"

def return_token(name):
    global results
    r = {}
    r['status']='wait...'
    if name in results_group.results.keys():
        token = results_group.results[name]['token']
        if token>0:
            r['status']='ok'
            r['token']=results_group.results[name]['token']
            results_group.removeResult(name)

    return r

