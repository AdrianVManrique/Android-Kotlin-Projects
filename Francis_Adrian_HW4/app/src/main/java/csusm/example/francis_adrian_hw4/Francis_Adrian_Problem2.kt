package csusm.example.francis_adrian_hw4

class Francis_Adrian_Problem2 {
    fun searchR(strings: Array<String>, str: String, first: Int, last: Int): Int {
        if (first > last) return -1
        /* Move mid to the middle */
        var mid = (last + first)/2

        /* if mid is empty, find the closest non-empty string. */if (strings[mid].isEmpty()) {
            var left = mid - 1
            var right = mid + 1
            while (true) {
                if (left < first && right > last) {
                    return -1
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right
                    break
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left
                    break
                }
                right++
                left--
            }
        }

        /* Check for string, and recurse if necessary */return if (str == strings[mid]) { // Found it!
            mid
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            searchR(strings, str, mid + 1, last)
        } else { // Search left
            searchR(strings, str, first, mid - 1)
        }
    }

    fun search(strings: Array<String>?, str: String?): Int {
        return if (strings == null || str == null || str === "") {
            -1
        } else searchR(
            strings,
            str,
            0,
            strings.size - 1
        )
    }
}