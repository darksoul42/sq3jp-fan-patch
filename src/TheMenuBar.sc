;;; Sierra Script 1.0 - (do not remove this comment)
(script# 997)
(include sci.sh)
(use Main)
(use Class_255_0)
(use n944)
(use Sound)
(use User)


(class TheMenuBar of Class_255_0
	(properties
		state $0000
	)
	
	(method (init)
		(AddMenu { _} {About game%jｹﾞｰﾑ ﾆﾂｲﾃ `^a :Help%jﾍﾙﾌﾟ`#1 :VaporCalc%jVaporCalc`^c :Language%jｹﾞﾝｺﾞ`^l :Subtitles%jｼﾞﾏｸ`^t_})
		(AddMenu
			{ File %j ﾌｧｲﾙ_}
			{Save Game%jｾｰﾌﾞ ｹﾞｰﾑ`#5 :Restore Game%jﾘｽﾄｱ ｹﾞｰﾑ`#7 :--! :Restart Game%jﾘｽﾀｰﾄ ｹﾞｰﾑ`#9 :Quit%jﾔﾒﾙ`^q_}
		)
		(AddMenu
			{ Action %j ｱｸｼｮﾝ_}
			{Pause Game%jｲﾁｼﾞｷｭｳｼ`^p :Inventory%jｲﾝﾍﾞﾝﾄﾘｰ`^I :Retype%jﾘﾋﾟｰﾄ`#3 :--! :Boss Key%jﾎﾞｽｷｰ`^b_}
		)
		(AddMenu
			{ Speed%jｽﾋﾟｰﾄﾞ_}
			{Change...%jﾍﾝｺｳｽﾙ`^s :--! :Faster%jﾊﾔｸｽﾙ`+ :Normal%jﾌﾂｳﾉﾊﾔｻ`= :Slower%jｵｿｸｽﾙ`-_}
		)
		(AddMenu { Sound%jｻｳﾝﾄﾞ_} {Volume...%jｻｳﾝﾄﾞﾁｮｳｾﾂ`^v :Sound Off%jｻｳﾝﾄﾞｦｹｽ`#2=1_})
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
	
	(method (handleEvent pEvent &tmp temp0 temp1 [temp2 201] tempDispLang tempSubtitles)
		(switch (super handleEvent: pEvent (User blocks?))
			(257
				(proc255_0
					(Format @temp2 997 0 global28)
					33
					3
					30
					1
					80
					{Space Quest %jｽﾍﾟｰｽ･ｸｴｽﾄ }
				)
			)
			(258 (proc255_0 997 1 33 3))
			(259 (= global251 1))
			(260
				(= tempDispLang (gGame printLang?))
				(proc255_0
					(Format
						@temp2
						{Switch Display Language: %d%j表示言語切替：%d}
						tempDispLang
						tempDispLang
					)
				)
				(switch tempDispLang
					(0
						(= tempDispLang 1)
					)
					(1
						(= tempDispLang 81)
					)
					(81
						(= tempDispLang 1)
					)
				)
				(gGame printLang: tempDispLang)
				(proc255_0
					(Format
						@temp2
						{Switched Display Language: %d%j表示言語切替完了：%d}
						tempDispLang
						tempDispLang
					)
				)
			)
			(261
				(= tempSubtitles (gGame subtitleLang?))
				(proc255_0
					(Format
						@temp2
						{Switch Subtitle Language : %d%j字幕言語切替：%d}
						tempSubtitles
						tempSubtitles
					)
				)
				(switch tempSubtitles
					(0
						(= tempSubtitles 1)
					)
					(1
						(= tempSubtitles 81)
					)
					(81
						(= tempSubtitles 1)
					)
				)
				(gGame subtitleLang: tempSubtitles)
				(proc255_0
					(Format
						@temp2
						{Switched Subtitle Language : %d%j字幕言語切替完了：%d}
						tempSubtitles
						tempSubtitles
					)
				)
			)
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
						{Restart%jﾘｽﾀｰﾄ}
						82
						602
						1
						0
						33
						300
						81
						{Restart%jﾘｽﾀｰﾄ}
						1
						81
						{Oops%jｲﾏﾉﾅｼ}
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
							{Bailing Out?%jﾆｹﾞﾙﾉｶ?}
							82
							602
							1
							0
							33
							300
							81
							{Quit%jﾔﾒﾙ}
							1
							81
							{Oops%jｲﾏﾉﾅｼ}
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
					{This game is paused.%jｹﾞｰﾑｶﾞｷｭｳｼｼﾃｲﾙ}
					82
					602
					1
					0
					33
					300
					81
					{Ok. I'm back.%jﾖｼ､ﾓﾄﾞｯﾀ}
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
						{In fact, you don't want your boss to know that you've been playing Space Quest ]I[ for %d hours, %d minutes and %d seconds.%j上司にバレたくないだろ、仕事を放り出してスペース・クエスト]I[をプレイしてるなんて。}
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
