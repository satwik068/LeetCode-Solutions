class Solution:
    def smallestNumber(self, num: str, t: int) -> str:
        # Step 1: Prime factorize t into 2, 3, 5, 7
        temp_t = t
        counts = {2: 0, 3: 0, 5: 0, 7: 0}
        for p in [2, 3, 5, 7]:
            while temp_t % p == 0:
                counts[p] += 1
                temp_t //= p
        
        # If t has prime factors > 7, it's impossible
        if temp_t > 1:
            return "-1"

        def get_min_digits(c2: int, c3: int, c5: int, c7: int) -> int:
            """Calculates minimum count of non-zero digits needed to satisfy factor counts."""
            c2, c3, c5, c7 = max(0, c2), max(0, c3), max(0, c5), max(0, c7)
            
            d9, r3 = divmod(c3, 2)
            d8, r2 = divmod(c2, 3)
            
            d6 = 0
            if r3 == 1 and r2 == 1:
                d6 = 1
                r3, r2 = 0, 0
            elif r3 == 1 and r2 == 2:
                d6 = 1
                r3, r2 = 0, 1
            
            d4, r2 = divmod(r2, 2)
            return d9 + d8 + d6 + d4 + r3 + r2 + c5 + c7

        def get_suffix(c2: int, c3: int, c5: int, c7: int, target_len: int) -> str:
            """Builds lexicographically smallest valid suffix of target_len."""
            c2, c3, c5, c7 = max(0, c2), max(0, c3), max(0, c5), max(0, c7)
            
            min_len = get_min_digits(c2, c3, c5, c7)
            ones = target_len - min_len
            
            d9, r3 = divmod(c3, 2)
            d8, r2 = divmod(c2, 3)
            
            d6 = 0
            if r3 == 1 and r2 == 1:
                d6 = 1
                r3, r2 = 0, 0
            elif r3 == 1 and r2 == 2:
                d6 = 1
                r3, r2 = 0, 1
                
            d4, r2 = divmod(r2, 2)
            
            digits = (
                ['2'] * r2 +
                ['3'] * r3 +
                ['4'] * d4 +
                ['5'] * c5 +
                ['6'] * d6 +
                ['7'] * c7 +
                ['8'] * d8 +
                ['9'] * d9
            )
            return "1" * ones + "".join(digits)

        # Factor contributions for digits '1' through '9'
        digit_factors = {
            '1': (0, 0, 0, 0), '2': (1, 0, 0, 0), '3': (0, 1, 0, 0),
            '4': (2, 0, 0, 0), '5': (0, 0, 1, 0), '6': (1, 1, 0, 0),
            '7': (0, 0, 0, 1), '8': (3, 0, 0, 0), '9': (0, 2, 0, 0)
        }

        n = len(num)
        first_zero = num.find('0')
        limit = first_zero if first_zero != -1 else n
        
        # Track required factors after prefix matching
        pref_c2, pref_c3, pref_c5, pref_c7 = counts[2], counts[3], counts[5], counts[7]
        prefix_reqs = [(pref_c2, pref_c3, pref_c5, pref_c7)]
        
        for i in range(limit):
            f2, f3, f5, f7 = digit_factors[num[i]]
            pref_c2 -= f2
            pref_c3 -= f3
            pref_c5 -= f5
            pref_c7 -= f7
            prefix_reqs.append((pref_c2, pref_c3, pref_c5, pref_c7))

        # Check if num itself is valid
        if first_zero == -1 and get_min_digits(*prefix_reqs[n]) == 0:
            return num

        # Step 2: Try changing digit at index i to a larger digit
        for i in range(limit, -1, -1):
            if i == n:
                continue
            
            c2, c3, c5, c7 = prefix_reqs[i]
            start_digit = int(num[i]) + 1 if i < limit else 1
            
            for d in range(start_digit, 10):
                d_str = str(d)
                f2, f3, f5, f7 = digit_factors[d_str]
                rem_c2, rem_c3 = c2 - f2, c3 - f3
                rem_c5, rem_c7 = c5 - f5, c7 - f7
                
                rem_len = n - 1 - i
                if get_min_digits(rem_c2, rem_c3, rem_c5, rem_c7) <= rem_len:
                    prefix = num[:i] + d_str
                    suffix = get_suffix(rem_c2, rem_c3, rem_c5, rem_c7, rem_len)
                    return prefix + suffix

        # Step 3: Expand to length n + 1 if same length is impossible
        target_len = max(n + 1, get_min_digits(counts[2], counts[3], counts[5], counts[7]))
        return get_suffix(counts[2], counts[3], counts[5], counts[7], target_len)