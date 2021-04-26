from lib import calc_lib

def limitsTest():
    x = calc_lib.execute(1)
    print("X(1): ", x)
    assert x==5, "Should be 5"
    x = calc_lib.execute(16)
    assert x==5, "Should be 5"
    print("X(16): ", x)

def seqTest():
    retVal = []
    for n in range(2,16):
        x = calc_lib.execute(n)
        retVal.append(x)
    return retVal

