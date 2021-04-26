from tests import test1
import time
#2,3,4,5,6,7,8,9,10,11,12,13,14,15
ret=[1,2,3,5,8,13,21,34,55,89,144,233,377,610]
a = time.time_ns()
retVal = test1.seqTest()
b = time.time_ns()
c = b - a
print("Time diff seconds: {}".format(c/1000000000))
mensagem = "Should return:" + str(ret) + " but returned: " + str(retVal)
assert retVal==ret, mensagem
test1.limitsTest()