#include <cstdio>
#include <iostream>
#include <algorithm>
using namespace std;


typedef long long int ll;
ll arr[200005];
ll n, c;

ll binarysearch(ll l, ll r) {
	ll L = l;
	ll R = r;
	ll ans = 0;
	while (L <= R) {

		ll mid = (L + R) / 2;
		ll cc = 1;
		ll wifi = arr[0];

		for (int i = 1; i < n; i++) {
			if (arr[i] - wifi >= mid) {
				cc++; //공유기설치
				wifi = arr[i]; //최근지점
			}
		}

		if (cc < c) { //와이파이설치개수가 넘지 못함(조건부합)//인접거리줄이기
			R = mid - 1;
		}
		else {
			if (mid > ans)ans =mid;
			L = mid + 1;
		}
	}

	return ans;
}
int main() {

	scanf("%d %d", &n, &c);
	for (int i = 0; i < n; i++)scanf("%lld", &arr[i]);

	sort(arr, arr + n);
	ll Max = arr[n - 1] - arr[0];
	ll ans = binarysearch(0, Max);

	printf("%lld\n", ans);
}