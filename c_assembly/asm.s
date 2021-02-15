.section .data
.section .text

.equ A_OFFSET, 4
.equ B_OFFSET, 8
.equ C_OFFSET, 12
.global calcTime					 # int calcTime(Scooter *scooter)

calcTime:

	# prologue
	pushl %ebp     	 				# save previous stack frame pointer
	movl %esp, %ebp	 				# the stack frame pointer for sum function

	movl 8(%ebp), %esi				# move pointer struct to esi
	movl (%esi), %ecx				# move bat_capacity in pointer struct to ecx
	movl A_OFFSET(%esi), %eax		# move max_capacity in pointer struct to ebx
	movl B_OFFSET(%esi), %ebx		# move actual_capacity in pointer struct to eax
	
	subl %ebx, %eax					# max_capacity - actual_capacity = eax
	imull %ecx, %eax				# bat_capacity * eax = eax
	movl $6, %ebx					# 6000 (battery eficiency * 100) = ebx
	movl $0, %edx					# free edx for remainder of division
	idivl %ebx						# ebx / eax = eax
	movl $13, %ebx					# charge current to ebx
	idivl %ebx						# eax / ebx = eax
		
# epilogue

movl %ebp, %esp   # restore the previous stack pointer ("clear" the stack)
popl %ebp         # restore the previous stack frame pointer
ret
