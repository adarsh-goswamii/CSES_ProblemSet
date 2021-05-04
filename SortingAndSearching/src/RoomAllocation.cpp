

#include<bits/stdc++.h>
using namespace std;

#define ll long long
#define mod 1000000007
#define maxn 200001
#define endl '\n'

void debug(int a[], int n) {
	for (int i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
}

void print(vector<int> v) {
	for (int i : v)
		cout << i << " ";
	cout << endl;
}

int ni() {
	int n;
	scanf("%d", &n);
	return n;
}

ll int nl() {
	ll int n;
	scanf("%lld", &n);
	return n;
}

string ns() {
	string s;
	getline(cin, s);
	return s;
}

double nd() {
	double n;
	scanf("%lf", &n);
	return n;
}

ll int add(ll int a, ll int b) {
	if (a + b >= mod)
		return (a + b) - mod;
	else
		return a + b >= 0 ? a + b : a + b + mod;
}

ll int mul(ll int a, ll int b) {
	return (a * b) % mod;
}

bool arrival(vector<int> a, vector<int> b) {
	if (a[0] < b[0]) return true;
	else if (a[0] == b[0] && a[1] < b[1]) return true;
	else return false;
}

bool leaving(vector<int> a, vector<int> b) {
	if (a[1] < b[1]) return true;
	else if (a[1] == b[1] && a[0] < b[0]) return true;
	else return false;
}

void solve() {
	int n = ni();

	set<int> room;
	for (int i = 1; i <= n; i++) room.insert(i);

	vector<vector<int>> v;
	vector<vector<int>> v2;
	int ans[n];

	for (int i = 0; i < n; i++) {
		vector<int> temp(4); // arrival, leaving, index, room allocated
		temp[0] = ni();
		temp[1] = ni();
		temp[2] = i;

		v.push_back(temp);
		v2.push_back(temp);
	}

	sort(v.begin(), v.end(), arrival);
	sort(v2.begin(), v2.end(), leaving);

	int j = 0, i = 0, required = 0;
	while (i != n) {
		while (v2[j][1] < v[i][0]) {
			room.insert(ans[v2[j++][2]]);
		}

		ans[v[i][2]] = *room.begin();
		required = max(required, *room.begin());
		i++;
		room.erase(*room.begin());
	}

	printf("%d\n", required);
	for (int i : ans)
		printf("%d ", i);
	printf("\n");
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr) , cout.tie(nullptr);
	int t = 1;
	// t = ni();

	while (t--) {
		solve();
	}

	return 0;
}
