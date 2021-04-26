from business.abstract_strategy import AbstractStrategy
from abc import ABC, abstractmethod
class AbstractFactory(ABC):

    @abstractmethod
    def create_calc_strategy(self) -> AbstractStrategy:
        pass
