import numpy as np
import time

def main():
    start = time.time()
    milion = int(1E+06)
    A = np.empty(milion)
    for i in range(0, milion-1):
        A[i] = (i+1)**2
    elapsed = time.time() - start
    print(elapsed)

if __name__ == "__main__":
    main()
