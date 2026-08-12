

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        current = head
        
        while current and current.next:
            if current.val == current.next.val:
                # Skip the duplicate node
                current.next = current.next.next
            else:
                # Move to the next node
                current = current.next
                
        return head