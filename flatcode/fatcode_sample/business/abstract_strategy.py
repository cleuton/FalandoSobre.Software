from abc import ABC, abstractmethod
class AbstractStrategy(ABC):

    @abstractmethod
    def calculate(self,name):
        pass