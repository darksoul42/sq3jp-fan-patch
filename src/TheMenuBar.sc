;;; Sierra Script 1.0 - (do not remove this comment)
(script# 997)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use User)


(class TheMenuBar of Class_255_0
	(properties
		state $0000
	)
	
	(method (init)
		(AddMenu { _} {About game%j�ް� �²� `^a :Help%j����`#1 :VaporCalc`^c_ :Language%j��ݺ�`^l})
		(AddMenu
			{ File %j ̧��_}
			{Save Game%j���� �ް�`#5 :Restore Game%jؽı �ް�`#7 :--! :Restart Game%jؽ��� �ް�`#9 :Quit%j���`^q_}
		)
		(AddMenu
			{ Action %j �����_}
			{Pause Game%j���޷���`^p :Inventory%j������ذ`^I :Retype%j��߰�`#3 :--! :Boss Key%j�޽��`^b_}
		)
		(AddMenu
			{ Speed_}
			{Change...%j�ݺ���`^s :--! :Faster%j�Ը��`+ :Normal%j�³��Ի`= :Slower%j�����`-_}
		)
		(AddMenu { Sound_} {Volume...%j����������`^v :Sound Off%js���ަ��`#2=1_})
		(SetMenu 513 109 'save')
		(SetMenu 514 109 'restore')
		(SetMenu 516 109 'restart')
		(SetMenu 517 109 'quit')
		(SetMenu 769 109 'pause')
		(SetMenu 770 109 'inventory')
		(SetMenu 1028 109 'normal')
		(SetMenu 1027 109 'faster')
		(SetMenu 1029 109 'slower')
		(SetMenu 258 109 'aid')
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1 [temp2 201])
		(switch (super handleEvent: pEvent (User blocks?))
			(257
				(proc255_0
					(Format @temp2 997 0 global28)
					33
					3
					30
					1
					80
					{Space Quest %j��߰������ }
				)
			)
			(258 (proc255_0 997 1 33 3))
			(259 (= global251 1))
			(513
				(if global193 (proc255_0 997 2) else (gGame save:))
			)
			(514 (gGame restore:))
			(516
				(if
					(proc255_0
						997
						3
						80
						{Restart%jؽ���}
						82
						602
						1
						0
						33
						300
						81
						{Restart%jؽ���}
						1
						81
						{Oops%j���ż}
						0
					)
					(gGame restart:)
				)
			)
			(517
				(if (!= gGNorth 290)
					(= global4
						(proc255_0
							997
							4
							80
							{Bailing Out?%jƹ��ɶ?}
							82
							602
							1
							0
							33
							300
							81
							{Quit%j���}
							1
							81
							{Oops%j���ż}
							0
						)
					)
				else
					(pEvent claimed: 0)
				)
			)
			(769
				(= temp0 (Sound pause: 1))
				(proc255_0
					997
					5
					80
					{This game is paused.%j�ްѶ޷����ò�}
					82
					602
					1
					0
					33
					300
					81
					{Ok. I'm back.%jּ���ޯ�}
					1
				)
				(DoSound sndPAUSE temp0)
			)
			(770 (gInv showSelf: gEgo))
			(771
				(pEvent claimed: 0 type: 4 message: (User echo?))
			)
			(773
				(proc255_0 997 6)
				(proc255_0
					(Format
						@temp2
						{In fact, you don't want your boss to know that you've been playing Space Quest ]I[ for %d hours, %d minutes and %d seconds.%j��i�Ƀo�������Ȃ�����A�d�������o���ăX�y�[�X�E�N�G�X�g]I[���v���C���Ă�Ȃ�āB}
						global228
						global227
						global226
					)
				)
				(proc255_0 997 7)
			)
			(1025
				(if
					(!=
						(= temp1 (proc255_3 {Speed (1 - 16)?} gNewSpeed))
						-1
					)
					(if (< temp1 1) (= temp1 1))
					(if (> temp1 16) (= temp1 16))
					(gGame setSpeed: temp1)
				)
			)
			(1027
				(if (> gNewSpeed 1) (gGame setSpeed: (-- gNewSpeed)))
			)
			(1028 (gGame setSpeed: 5))
			(1029
				(if (< gNewSpeed 16) (gGame setSpeed: (++ gNewSpeed)))
			)
			(1281
				(if
					(!=
						(= temp1
							(proc255_3 {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
						)
						-1
					)
					(if (< (-- temp1) 0) (= temp1 0))
					(if (> temp1 15) (= temp1 15))
					(DoSound sndVOLUME temp1)
				)
			)
			(1282
				(if (GetMenu 1282 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1282 113 0 110 {Turn on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1282 113 1 110 {Turn off})
				)
			)
		)
	)
)