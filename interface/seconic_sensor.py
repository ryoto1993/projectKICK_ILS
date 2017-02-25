# -*- coding: utf-8 -*-

import socket
import time
import sys

host = []
#host.append('192.168.1.7') 
#host.append('192.168.1.5') 
#host.append('192.168.1.9') 
#host.append('192.168.1.6') 

# ToDo: Sekonicディジタル照度センサのIPをKICKのものに変更
host.append('192.168.2.9') 
host.append('192.168.2.5')
host.append('192.168.2.3') 
host.append('192.168.2.6') 

port = 9001
clientsock = []
head = chr(0x2)
cmd = '00010000\r\n'
message = head + cmd
count = 0

change = '0002'
length = '0005'
attendance_info = '1'
target_info = '0500'
change_message = head + change + length + attendance_info + target_info

for h in host : 
	print 'init'
	clientsock.append(socket.socket(socket.AF_INET,socket.SOCK_STREAM))
	clientsock[count].connect((h,port))
	count += 1
while True:
	attendance = [] 
	target = [] 
	illuminance = [] 
	rcvmsg = []
	count = 0
	flag = 0
	
	try:
		f = open('ui_flag.txt', 'r')
		for line in f:
			flag = int(line)
			print flag
		f.close()
	except IOError:
		print "file does not read"
	
	attendances = []
	target_ills = []
	
#	if flag == 1:
#		try:
#			f = open('target.txt', 'r')
#			for line in f:
#				items = line.split(',')
#				attendances.append(int(items[1]))
#				target_ills.append(int(items[0]))
#				
#		except IOError:
#			print "file does not read"			
#		time.sleep(0.5)
	
	if flag == 1:
		try:
			f = open(r"target.txt", 'r')
			m = f.read()
			target_ills = m.split(",")
			f.close()
		except IOError:
			print "file does not read"
			
		try:
			f = open(r"attendance.txt", 'r')
			m = f.read()
			attendances = m.split(",")
			f.close()
		except IOError:
			print "file does not read"

		time.sleep(1.0)
	
	for h in host: 
		if flag == 1:
			print "count",count
			attendance_info = str(attendances[count])
			target_info = str(0)+str(target_ills[count])
			if int(target_ills[count]) >=1000:
				target_info = str(target_ills[count])
			
			change_message = head + change + length + attendance_info + target_info 
			print change_message
			clientsock[count].sendall(change_message)
			rcvmsg.append(clientsock[count].recv(1024))
		else:
			clientsock[count].sendall(message)
			rcvmsg.append(clientsock[count].recv(1024))
			print "attendance:"
			
			if int(list(rcvmsg[count])[10]) == 1:
				print 'sitting'
				attendance.append('1')
			else:
				print 'leaving'
				attendance.append('0')
			
			print "Lux       :",float(list(rcvmsg[count])[11]+list(rcvmsg[count])[12]+list(rcvmsg[count])[13]+list(rcvmsg[count])[14]+'.'+list(rcvmsg[count])[15])
			illuminance.append( float(list(rcvmsg[count])[11]+list(rcvmsg[count])[12]+list(rcvmsg[count])[13]+list(rcvmsg[count])[14]+'.'+list(rcvmsg[count])[15] ))
			
			print "target    :",int(list(rcvmsg[count])[16]+list(rcvmsg[count])[17]+list(rcvmsg[count])[18]+list(rcvmsg[count])[19])
			target.append( int(list(rcvmsg[count])[16]+list(rcvmsg[count])[17]+list(rcvmsg[count])[18]+list(rcvmsg[count])[19]) )
		count += 1
	
	if flag == 1:
		try:
			f = open(r"ui_flag.txt","w")
			line = '0\n'
			f.write(line)
			f.close()
		except IOError:
			print "file does not read"		
	else:	
		try:
			f = open("sensor.txt","w")
			line = ''
			for ill in illuminance :
				line += str(ill) + ','
			f.write(line)
			f.close()
		except IOError:
			print "file does not read sensor"

		try:	
			f = open(r"target.txt","w")
			line = ''
			for tar in target:
				line += str(tar) + ','
			f.write(line)
			f.close()
		except IOError:
			print "file does not read target"
			
		try:
			f = open(r"attendance.txt","w")
			line = ''
			for tar in attendance:
				line += str(tar) + ','
			f.write(line)
			f.close()
		except IOError:
			print "file does not read attendance"
			
				
		#try:			
		#	f = open(r"target.txt","w")
		#	line = ''
		#	for i in range(len(target)):
		#		line += str(target[i]) + ','+str(attendance[i])+'\n'
		#	f.write(line)
		#	f.close()
		#except IOError:
		#	print "file does not read"
			
	
	time.sleep(1.0)
#close socket
clientsock.close()
