package com.leetcode.solved;

public class CreateMaximumNumber {
	public int[] findGreater(int[] A, int[] B){
        for(int i = 0; i < A.length; i++){
          if(A[i] == B[i]) continue;
          return (A[i] > B[i]) ? A : B;
        } 
        return A;
    }
    private int[] mergeArray(int A[], int B[]){
        if(A == null || A.length == 0) return B;
        if(B == null || B.length == 0) return A;
        
        int result[] = new int[A.length + B.length];
        int indexA = 0;
        int indexB = 0;
        int indexR = 0;
        
        while(indexA < A.length && indexB < B.length){
            if(chooseA(A,indexA,B,indexB)) result[indexR++] = A[indexA++];
            else result[indexR++] = B[indexB++];
        }
        
        while(indexA < A.length) result[indexR++] = A[indexA++];
        while(indexB < B.length) result[indexR++] = B[indexB++];
        
        return result;
    }
    private boolean chooseA(int A[], int i, int B[], int j){
        while(i < A.length && j < B.length && A[i] == B[j]){ i++; j++;}
        if(j == B.length) return true;
        if(i == A.length) return false;
        return (A[i] > B[j]);
    }
    private int[] chooseKNums(int[] A, int count){
        if(count == 0) return new int[0];
        if(count > A.length) return A;
        int[] result = new int[count];
        for(int i = 0; i < count; i++) result[i] = A[i];
        for(int i = count; i < A.length; i++){
            int index = 0;
            while(index < count-1 && result[index] >= result[index+1]) index++;
            while(index < count-1){
              result[index] = result[++index];  
              if(index == count-1) result[index] = A[i];
            } 
            if(result[index] < A[i]) result[index] = A[i];
        }
        return result;
    }
    public int[] maxNumber(int[] A, int[] B, int k) {
        if(A.length < B.length) return maxNumber(B,A,k);
        
        int minElementA = Integer.max(0,k - B.length);
        int maxElementA = Integer.min(A.length,k);
        if(k == 0) return new int[0];
        int maxNum[] = new int[k];
        for(int i = minElementA; i <= maxElementA; i++){
            int aArray[] = chooseKNums(A,i);
            int bArray[] = chooseKNums(B,k-i);
            maxNum = findGreater(mergeArray(aArray,bArray),maxNum);
        }
        return maxNum;
    }

}
