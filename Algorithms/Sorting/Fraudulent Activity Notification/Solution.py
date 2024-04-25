#!/bin/python3

import math
import os
import random
import re
import sys
import collections

#
# Complete the 'activityNotifications' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY expenditure
#  2. INTEGER d
#

def activityNotifications(expenditure, d):
    # Write your code here
    result  = 0
    freq = collections.Counter(expenditure[:d])

    for i in range(d-1, len(expenditure)-1):
        median = getMedian(freq, d)
        if expenditure[i+1] >= median :
            result  += 1

        freq[expenditure[i-d+1]] -= 1
        freq[expenditure[i+1]] += 1
    return result

def getMedian(freq, d): # return median * 2
    s = 0
    d1, d2 = d//2, d//2 + 1
    for i in sorted(freq):
        s += freq[i]
        if d % 2 == 0:
            if s == d1:
                for j in range(i+1, 201):
                    if freq[j]>0:
                        return (i+j)
            if s > d1:
                return i*2
        else:
            if s >= d2:
                return i*2

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    d = int(first_multiple_input[1])

    expenditure = list(map(int, input().rstrip().split()))

    result = activityNotifications(expenditure, d)

    fptr.write(str(result) + '\n')

    fptr.close()
