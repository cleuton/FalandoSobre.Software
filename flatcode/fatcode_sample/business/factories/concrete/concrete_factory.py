from business.concrete.concrete_strategy import ConcreteStrategy
from business.factories.abstract_strategy_factory import AbstractFactory
class ConcreteFactory(AbstractFactory):
    def create_calc_strategy(self) -> ConcreteStrategy:
        return ConcreteStrategy()