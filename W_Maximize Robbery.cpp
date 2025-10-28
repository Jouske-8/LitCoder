// Code Accuracy 100.00%
// Code Quality 86.67%
// Code Accuracy 92.50%
#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;

int solve(const vector<int> &nums) {
    if(nums.empty()){
        return 0;
    }
    int robpp = 0;
    int robp = 0;
    
    for(int curr : nums){
        int currMax = max(robp, curr + robpp);
        
        robpp = robp;
        robp = currMax;
    }
    
    return robp;
}

int main(){
    string input;
    getline(cin, input);
    
    stringstream ss(input);
    int num;
    vector<int> arr;
    while(ss >> num){
        arr.push_back(num);
    }
    cout<<solve(arr)<<endl;
    return 0;
}
