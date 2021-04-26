from business.abstract_strategy import AbstractStrategy
from business.token_function import calc_token

class ConcreteStrategy(AbstractStrategy):
    def calculate(self,name):
        if len(name) < 3 or len(name) >15:
            tamanho = 5
        else:
            tamanho  = len(name)
        result = {}
        result['name']=name
        result['token']=calc_token(tamanho)
        return result