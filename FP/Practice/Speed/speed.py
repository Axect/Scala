import numpy as np

def main():
    milion = int(1E+06)
    A = np.empty(milion)
    for i in range(0, milion-1):
        A[i] = (i+1)**2

if __name__ == "__main__":
    main()
