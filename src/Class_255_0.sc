;;; Sierra Script 1.0 - (do not remove this comment)
(script# 255)
(include sci.sh)
(use Main)
(use Obj)

(public
	proc255_0 0
	proc255_1 1
	proc255_2 2
	proc255_3 3
	proc255_4 4
)

(local
	local0
	[local1 20]
)
(procedure (proc255_0 param1 &tmp newDialog newDText_2 newDIcon newDEdit temp4 temp5 temp6 temp7 temp8 theNewDialog temp10 activePort [newDButton 6] temp18 temp19 temp20 [tempString 1001] tempStringCounter newDText final_newDText textWithSubtitles gGamePrintLang gGameSubtitleLang dialog_option70 dialog_option82 textShift dialog_option107)
	(= dialog_option70 0)
	(= dialog_option82 0)
	(= dialog_option107 0)
	(= temp6 (= temp7 -1))
	(= theNewDialog
		(= temp8
			(= temp18 (= newDIcon (= newDEdit (= temp19 0))))
		)
	)
	(= [newDButton 0]
		(= [newDButton 1]
			(= [newDButton 2]
				(= [newDButton 3]
					(= [newDButton 4] (= [newDButton 5] 0))
				)
			)
		)
	)
	(= newDialog (Dialog new:))
	(= newDText (DText new:))
	; PARSE RESOURCE ARGUMENTS FIRST
	(cond
		((u< [param1 0] 1000) (GetFarText [param1 0] [param1 1] @tempString) (= temp5 2))
		([param1 0] (StrCpy @tempString [param1 0]) (= temp5 1))
		(else (= tempString 0) (= temp5 0))
	)
	; PARSE JAPANESE
	(= tempStringCounter 0)
	(while (StrAt @tempString tempStringCounter)
		(if
			(and
				(== (StrAt @tempString tempStringCounter) 37)
				(== (StrAt @tempString (+ 1 tempStringCounter)) 74)
			)
			(gGame printLang: 1 subtitleLang: 81)
			(kernel_120 @tempString @tempString {%J})
			(gGame
				printLang: gGamePrintLang
				subtitleLang: gGameSubtitleLang
			)
			(StrAt @tempString tempStringCounter 0)
			(if (proc999_5 81 gGamePrintLang gGameSubtitleLang)
				((= newDText (DText new:))
					text: (+ @tempString 2 tempStringCounter)
					font: 900
					name: {jDText}
				)
			)
		)
		(++ tempStringCounter)
	)
	; PUT TEMPSTRING IN newDText
	((= newDText_2 (DText new:))
		text: @tempString
		font: global22
	)
	; SET FINAL OBJECT BASED ON LANGUAGE
	(= final_newDText
		(if (and newDText (== gGamePrintLang 81))
			newDText
		else
			newDText_2
		)
	)
	; SET TEXT TO DISPLAY BASED ON SUBTITLE SETTINGS ?
	(= textWithSubtitles
		(cond
			((== gGameSubtitleLang 81) newDText)
			(newDText
				(if gGameSubtitleLang
					newDText_2
				else
					(newDText_2 dispose:)
					(= newDText_2 0)
				)
			)
		)
	)
	(final_newDText name: {PrintD} moveTo: 4 4 setSize:)
	(if textWithSubtitles
		(textWithSubtitles
			setSize:
			moveTo: (final_newDText nsLeft?) (+ 4 (final_newDText nsBottom?))
		)
	        (newDialog add: textWithSubtitles setSize:)
	)
; BROWSE ARGUMENTS
	(= temp5 temp5)
	(while (< temp5 argc)
		(switch [param1 temp5]
			(30
				(++ temp5)
				(if (and newDText_2 (not textWithSubtitles))
					(newDText_2 mode: [param1 temp5])
				)
			)
			(33
				(++ temp5)
				(if newDText_2
					(newDText_2 font: [param1 temp5] setSize: temp8)
				)
			)
			(70
				(= dialog_option70 1)
				(= temp8 [param1 (++ temp5)])
				(final_newDText setSize: temp8)
				(if textWithSubtitles
					(textWithSubtitles
						setSize: temp8
						moveTo: (final_newDText nsLeft?) (+ 4 (final_newDText nsBottom?))
					)
				)
			)
			(25
				(newDialog time: [param1 (++ temp5)])
			)
			(80
				(newDialog text: [param1 (++ temp5)])
			)
			(67
				(= temp6 [param1 (++ temp5)])
				(= temp7 [param1 (++ temp5)])
			)
			(83
				(Animate (gCast elements?) 0)
			)
			(41
				((= newDEdit (DEdit new:)) text: [param1 (++ temp5)])
				(newDEdit max: [param1 (++ temp5)] setSize:)
			)
			(81
				((= [newDButton temp19] (DButton new:))
					text: [param1 (++ temp5)]
					value: [param1 (++ temp5)]
					setSize:
				)
				(= temp18 (+ temp18 ([newDButton temp19] nsRight?) 4))
				(++ temp19)
			)
			(82
				(= dialog_option82 1)
				(if newDIcon
					(= temp5 (+ temp5 3))
				else
					(= newDIcon (DIcon new:))
					(newDIcon view: [param1 (++ temp5)])
					(newDIcon loop: [param1 (++ temp5)])
					(newDIcon cel: [param1 (++ temp5)])
					(newDIcon setSize:)
				)
			)
			(88
				(if gTheNewDialog (gTheNewDialog dispose:))
				(= theNewDialog newDialog)
			)
			(93
				(if gTheNewDialog (gTheNewDialog dispose:))
				(= theNewDialog newDialog)
			)
			(107 (= dialog_option107 1))
		)
		(++ temp5)
	)
        ; OPTION PROCESSING
        (if dialog_option107 (= theNewDialog 0))
        (if
                (and
                        (not (if dialog_option70 else dialog_option82))
                        (> (- (newDialog nsBottom?) (newDialog nsTop?)) 100)
                )
                (final_newDText setSize: 300)
                (if textWithSubtitles
                        (textWithSubtitles
                                setSize: 300
                                moveTo: (final_newDText nsLeft?) (+ 4 (final_newDText nsBottom?))
                        )
                )
        )
        ; END OF OPTION PROCESSING
	(if newDIcon
		(newDIcon moveTo: 4 4)
                (if
                (or (== final_newDText newDText) (== textWithSubtitles newDText))
                        (= textShift 8)
                )
                (final_newDText
                        moveTo: (+ 4 (newDIcon nsRight?) textShift) (final_newDText nsTop?)
                        setSize:
                )
                (if textWithSubtitles
                        (textWithSubtitles
                                moveTo: (final_newDText nsLeft?) (+ 4 (final_newDText nsBottom?))
                        )
		)
		(newDialog add: newDIcon)
	)
	(newDialog setSize:)
	(if newDEdit
		(newDEdit
			moveTo:
				((if textWithSubtitles else final_newDText) nsLeft?)
				(+ 4 ((if textWithSubtitles else final_newDText) nsBottom?))
		)
		(newDialog add: newDEdit setSize:)
	)
	(= temp20
		(if (> temp18 (newDialog nsRight?))
			4
		else
			(- (newDialog nsRight?) temp18)
		)
	)
	(= temp5 0)
	(while [newDButton temp5]
		([newDButton temp5] moveTo: temp20 (newDialog nsBottom?))
		(newDialog add: [newDButton temp5])
		(= temp20 (+ 4 ([newDButton temp5] nsRight?)))
		(++ temp5)
	)
	(newDialog setSize: center:)
	(if (and newDIcon (not (StrLen @tempString)))
		(newDIcon
			moveTo:
				(/
					(-
						(- (newDialog nsRight?) (newDialog nsLeft?))
						(- (newDIcon nsRight?) (newDIcon nsLeft?))
					)
					2
				)
				4
		)
	)
	(newDialog
		moveTo:
			(if (== -1 temp6) (newDialog nsLeft?) else temp6)
			(if (== -1 temp7) (newDialog nsTop?) else temp7)
	)
	(= activePort (GetPort))
	(newDialog
		open: (if (newDialog text?) 4 else 0) (if theNewDialog 15 else -1)
	)
	(if theNewDialog
		(= local0 (GetPort))
		(SetPort activePort)
		(return (= gTheNewDialog theNewDialog))
	)
	(if
		(and
			(= temp10 (newDialog firstTrue: #checkState 1))
			(not (newDialog firstTrue: #checkState 2))
		)
		(temp10 state: (| (temp10 state?) $0002))
	)
	(if (== (= temp4 (newDialog doit: temp10)) -1)
		(= temp4 0)
	)
	(= temp5 0)
	(while [newDButton temp5]
		(breakif (== temp4 [newDButton temp5]))
		(++ temp5)
	)
	(newDialog dispose:)
	(return temp4)
)

(procedure (proc255_1 param1 param2 param3 param4)
	(proc255_0 param1 82 param2 param3 param4 &rest)
)

(procedure (proc255_2 param1 param2 param3 &tmp [temp0 4])
	(if
		(proc255_0
			(if (>= argc 3) param3 else {})
			41
			param1
			param2
			&rest
		)
		(StrLen param1)
	)
)

(procedure (proc255_3 param1 param2 &tmp [temp0 40])
	(= temp0 0)
	(if (> argc 1) (Format @temp0 255 0 param2))
	(return
		(if (proc255_2 @temp0 5 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(procedure (proc255_4 &tmp [temp0 500])
	(Format @temp0 &rest)
	(proc255_0 @temp0)
)

(procedure (localproc_0014 &tmp newEvent temp1)
	(= temp1 (!= ((= newEvent (Event new:)) type?) 2))
	(newEvent dispose:)
	(return temp1)
)

(class Class_255_0 of Obj
	(properties
		state $0000
	)
	
	(method (draw)
		(= state 1)
		(DrawMenuBar 1)
	)
	
	(method (hide)
		(DrawMenuBar 0)
	)
	
	(method (handleEvent pEvent)
		(return (if state (MenuSelect pEvent &rest) else 0))
	)
	
	(method (add)
		(AddMenu &rest)
	)
)

(class Class_255_1 of Obj
	(properties
		type $0000
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)
	
	(method (enable param1)
		(if (or (== argc 0) param1)
			(= state (| state $0001))
		else
			(= state (& state $fffe))
		)
	)
	
	(method (select param1)
		(if (or (== argc 0) param1)
			(= state (| state $0008))
		else
			(= state (& state $fff7))
		)
	)
	
	(method (handleEvent pEvent &tmp temp0 pEventType temp2)
		(if (pEvent claimed?) (return 0))
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and
						(== (= pEventType (pEvent type?)) 128)
						(Said said)
					)
					(and
						(== pEventType evKEYBOARD)
						(== (pEvent message?) key)
					)
					(and (== pEventType evMOUSEBUTTON) (self check: pEvent))
				)
			)
			(pEvent claimed: 1)
			(= temp0 (self track: pEvent))
		)
		(return temp0)
	)
	
	(method (check param1)
		(return
			(if
				(and
					(>= (param1 x?) nsLeft)
					(>= (param1 y?) nsTop)
					(< (param1 x?) nsRight)
				)
				(< (param1 y?) nsBottom)
			else
				0
			)
		)
	)
	
	(method (track param1 &tmp temp0 temp1)
		(return
			(if (== 1 (param1 type?))
				(= temp1 0)
				(repeat
					(= param1 (Event new: -32768))
					(GlobalToLocal param1)
					(if (!= (= temp0 (self check: param1)) temp1)
						(HiliteControl self)
						(= temp1 temp0)
					)
					(param1 dispose:)
					(breakif (not (localproc_0014)))
				)
				(if temp0 (HiliteControl self))
				(return temp0)
			else
				(return self)
			)
		)
	)
)

(class DItem of Class_255_1
	(properties
		type $0000
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)
	
	(method (doit)
		(return value)
	)
	
	(method (select param1)
		(super select: param1)
		(self draw:)
	)
	
	(method (setSize)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (draw)
		(DrawControl self)
	)
	
	(method (isType param1)
		(return (== type param1))
	)
	
	(method (checkState param1)
		(return (& state param1))
	)
)

(class DText of DItem
	(properties
		type $0002
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 1
		mode 0
	)
	
	(method (new &tmp newSuper)
		((= newSuper (super new:)) font: global22)
		(return newSuper)
	)
	
	(method (setSize param1 &tmp [temp0 4])
		(TextSize @[temp0 0] text font (if argc param1 else 0))
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft [temp0 3]))
	)
)

(class DIcon of DItem
	(properties
		type $0004
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		view 0
		loop 0
		cel 0
	)
	
	(method (setSize &tmp [temp0 4])
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
	)
)

(class DButton of DItem
	(properties
		type $0001
		state $0003
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] text font)
		(= [temp0 2] (+ [temp0 2] 2))
		(= [temp0 3] (+ [temp0 3] 2))
		(= nsBottom (+ nsTop [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= nsRight (+ [temp0 3] nsLeft))
	)
)

(class DEdit of DItem
	(properties
		type $0003
		state $0001
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		text 0
		font 0
		max 0
		cursor 0
	)
	
	(method (track param1)
		(EditControl self param1)
		(return self)
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] {M} font)
		(= nsBottom (+ nsTop [temp0 2]))
		(= nsRight (+ nsLeft (/ (* [temp0 3] max 3) 4)))
		(= cursor (StrLen text))
	)
)

(class DSelector of DItem
	(properties
		type $0006
		state $0000
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
		font 0
		x 20
		y 6
		text 0
		cursor 0
		lsTop 0
		mark 0
	)
	
	(method (handleEvent pEvent &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (pEvent claimed?) (return 0))
		(if (== evJOYSTICK (pEvent type?))
			(pEvent type: 4)
			(switch (pEvent message?)
				(JOY_DOWN
					(pEvent message: 20480)
				)
				(JOY_UP (pEvent message: 18432))
				(else  (pEvent type: 64))
			)
		)
		(= temp0 0)
		(switch (pEvent type?)
			(evKEYBOARD
				(pEvent claimed: 1)
				(switch (pEvent message?)
					(KEY_NUMPAD7 (self retreat: 50))
					(KEY_NUMPAD1 (self advance: 50))
					(KEY_PAGEUP
						(self advance: (- y 1))
					)
					(KEY_PAGEDOWN
						(self retreat: (- y 1))
					)
					(KEY_NUMPAD2 (self advance: 1))
					(KEY_UP (self retreat: 1))
					(else  (pEvent claimed: 0))
				)
			)
			(evMOUSEBUTTON
				(if (self check: pEvent)
					(pEvent claimed: 1)
					(cond
						((< (pEvent y?) (+ nsTop 10))
							(repeat
								(self retreat: 1)
								(breakif (not (localproc_0014)))
							)
						)
						((> (pEvent y?) (- nsBottom 10))
							(repeat
								(self advance: 1)
								(breakif (not (localproc_0014)))
							)
						)
						(else
							(TextSize @[temp5 0] {M} font)
							(if
								(>
									(= temp4 (/ (- (pEvent y?) (+ nsTop 10)) [temp5 2]))
									mark
								)
								(self advance: (- temp4 mark))
							else
								(self retreat: (- mark temp4))
							)
						)
					)
				)
			)
		)
		(return (if (pEvent claimed?) self else 0))
	)
	
	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] {M} font)
		(= nsBottom (+ nsTop 20 (* [temp0 2] y)))
		(= nsRight (+ nsLeft (/ (* [temp0 3] x 3) 4)))
		(= lsTop (= cursor text))
		(= mark 0)
	)
	
	(method (indexOf param1 &tmp theText temp1)
		(= theText text)
		(= temp1 0)
		(return
			(while (< temp1 300)
				(if (== 0 (StrLen theText)) (return -1))
				(if (not (StrCmp param1 theText)) (return temp1))
				(= theText (+ theText x))
				(++ temp1)
			)
		)
	)
	
	(method (at param1)
		(return (+ text (* x param1)))
	)
	
	(method (advance param1 &tmp temp0)
		(= temp0 0)
		(while (and param1 (StrAt cursor x))
			(= temp0 1)
			(= cursor (+ cursor x))
			(if (< (+ mark 1) y)
				(++ mark)
			else
				(= lsTop (+ lsTop x))
			)
			(-- param1)
		)
		(if temp0 (self draw:))
	)
	
	(method (retreat param1 &tmp temp0)
		(= temp0 0)
		(while (and param1 (!= cursor text))
			(= temp0 1)
			(= cursor (- cursor x))
			(if mark (-- mark) else (= lsTop (- lsTop x)))
			(-- param1)
		)
		(if temp0 (self draw:))
	)
)

(class Dialog of List
	(properties
		elements 0
		size 0
		text 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		timer 0
		busy 0
	)
	
	(method (doit param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(asm
			ldi      0
			sat      temp0
			ldi      1
			aTop     busy
			pToa     theItem
			bnt      code_0924
			pushi    #select
			pushi    1
			pushi    0
			send     6
code_0924:
			lap      argc
			bnt      code_0933
			lap      param1
			bnt      code_0933
			lap      param1
			jmp      code_093c
code_0933:
			pushi    #firstTrue
			pushi    2
			pushi    146
			pushi    1
			self     8
code_093c:
			aTop     theItem
			pToa     theItem
			bnt      code_094a
			pushi    #select
			pushi    1
			pushi    1
			send     6
code_094a:
			pToa     theItem
			not
			bnt      code_095d
			ldi      60
			sat      temp3
			pushi    0
			callk    GetTime,  0
			sat      temp4
			jmp      code_0961
code_095d:
			ldi      0
			sat      temp3
code_0961:
			ldi      0
			sat      temp2
code_0965:
			lat      temp2
			not
			bnt      code_09e5
			pushi    1
			pushi    #new
			pushi    0
			class    Event
			send     4
			sat      temp1
			push
			callk    GlobalToLocal,  2
			lat      temp3
			bnt      code_09ac
			-at      temp3
			pushi    #type
			pushi    0
			lat      temp1
			send     4
			push
			ldi      1
			eq?
			bnt      code_0996
			pushi    #type
			pushi    1
			pushi    0
			lat      temp1
			send     6
code_0996:
			lst      temp4
			pushi    0
			callk    GetTime,  0
			eq?
			bnt      code_09a6
			jmp      code_0996
			jmp      code_0996
code_09a6:
			pushi    0
			callk    GetTime,  0
			sat      temp4
code_09ac:
			pushi    #handleEvent
			pushi    1
			lst      temp1
			self     6
			sat      temp2
			pushi    #dispose
			pushi    0
			lat      temp1
			send     4
			pToa     timer
			bnt      code_09c6
			pushi    #doit
			pushi    0
			send     4
code_09c6:
			lst      temp2
			ldi      65535
			eq?
			bt       code_09d4
			pToa     busy
			not
			bnt      code_0965
code_09d4:
			ldi      0
			sat      temp2
			pushi    2
			pTos     theItem
			pushi    0
			callk    EditControl,  4
			jmp      code_09e5
			jmp      code_0965
code_09e5:
			ldi      0
			aTop     busy
			lat      temp2
			ret
		)
	)
	
	(method (dispose)
		(if (== self gTheNewDialog) (SetPort local0))
		(if window (DisposeWindow window))
		(= window 0)
		(if (== self gTheNewDialog)
			(= gTheNewDialog 0)
			(= local0 0)
		)
		(if timer (timer dispose: delete:))
		(= theItem 0)
		(super dispose:)
	)
	
	(method (open param1 param2)
		(if (not window)
			(if (and (PicNotValid) gCast)
				(Animate (gCast elements?) 0)
			)
			(= window
				(NewWindow
					nsTop
					nsLeft
					nsBottom
					nsRight
					text
					param1
					param2
				)
			)
		)
		(if time (Timer setReal: self time))
		(self draw:)
	)
	
	(method (draw)
		(self eachElementDo: #draw)
	)
	
	(method (cue)
		(if (not busy) (self dispose:) else (= busy 0))
	)
	
	(method (advance &tmp temp0 dialogFirst)
		(if theItem
			(theItem select: 0)
			(= dialogFirst (self contains: theItem))
			(repeat
				(if (not (= dialogFirst (self next: dialogFirst)))
					(= dialogFirst (self first:))
				)
				(= theItem (NodeValue dialogFirst))
				(breakif (& (theItem state?) $0001))
			)
			(theItem select: 1)
		)
	)
	
	(method (retreat &tmp temp0 dialogLast)
		(if theItem
			(theItem select: 0)
			(= dialogLast (self contains: theItem))
			(repeat
				(if (not (= dialogLast (self prev: dialogLast)))
					(= dialogLast (self last:))
				)
				(= theItem (NodeValue dialogLast))
				(breakif (& (theItem state?) $0001))
			)
			(theItem select: 1)
		)
	)
	
	(method (move param1 param2)
		(= nsRight (+ nsRight param1))
		(= nsLeft (+ nsLeft param1))
		(= nsTop (+ nsTop param2))
		(= nsBottom (+ nsBottom param2))
	)
	
	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)
	
	(method (center)
		(self
			moveTo:
				(/ (- 320 (- nsRight nsLeft)) 2)
				(/ (- 200 (- nsBottom nsTop)) 2)
		)
	)
	
	(method (setSize &tmp dialogFirst temp1 [theNsTop 4])
		(if text
			(TextSize @[theNsTop 0] text 0 -1)
			(= nsTop [theNsTop 0])
			(= nsLeft [theNsTop 1])
			(= nsBottom [theNsTop 2])
			(= nsRight [theNsTop 3])
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(= dialogFirst (self first:))
		(while dialogFirst
			(if
			(< ((= temp1 (NodeValue dialogFirst)) nsLeft?) nsLeft)
				(= nsLeft (temp1 nsLeft?))
			)
			(if (< (temp1 nsTop?) nsTop) (= nsTop (temp1 nsTop?)))
			(if (> (temp1 nsRight?) nsRight)
				(= nsRight (temp1 nsRight?))
			)
			(if (> (temp1 nsBottom?) nsBottom)
				(= nsBottom (temp1 nsBottom?))
			)
			(= dialogFirst (self next: dialogFirst))
		)
		(= nsRight (+ nsRight 4))
		(= nsBottom (+ nsBottom 4))
		(self moveTo: 0 0)
	)
	
	(method (handleEvent pEvent &tmp theTheItem)
		(if
			(or
				(pEvent claimed?)
				(== (pEvent type?) evNULL)
				(and
					(!= evMOUSEBUTTON (pEvent type?))
					(!= evKEYBOARD (pEvent type?))
					(!= evJOYSTICK (pEvent type?))
					(!= evJOYDOWN (pEvent type?))
				)
			)
			(EditControl theItem pEvent)
			(return 0)
		)
		(if
		(= theTheItem (self firstTrue: #handleEvent pEvent))
			(EditControl theItem 0)
			(cond
				((theTheItem isType: 3)
					(if theItem (theItem select: 0))
					((= theItem theTheItem) select: 1)
					(= theTheItem 0)
				)
				(
					(and
						(not (theTheItem isType: 6))
						(not (theTheItem checkState: 2))
					)
					(theTheItem doit:)
					(self advance:)
					(= theTheItem 0)
				)
			)
		else
			(= theTheItem 0)
			(cond
				(
					(and
						(or
							(== (pEvent type?) evJOYDOWN)
							(and
								(== evKEYBOARD (pEvent type?))
								(== KEY_RETURN (pEvent message?))
							)
						)
						theItem
						(theItem checkState: 1)
					)
					(= theTheItem theItem)
					(EditControl theItem 0)
					(pEvent claimed: 1)
				)
				(
					(or
						(and
							(not (self firstTrue: #checkState 1))
							(or
								(and
									(== evKEYBOARD (pEvent type?))
									(== KEY_RETURN (pEvent message?))
								)
								(== evMOUSEBUTTON (pEvent type?))
								(== evJOYDOWN (pEvent type?))
							)
						)
						(and
							(== evKEYBOARD (pEvent type?))
							(== KEY_ESCAPE (pEvent message?))
						)
					)
					(pEvent claimed: 1)
					(= theTheItem -1)
				)
				(
					(and
						(== evKEYBOARD (pEvent type?))
						(== KEY_TAB (pEvent message?))
					)
					(pEvent claimed: 1)
					(self advance:)
				)
				(
					(and
						(== evKEYBOARD (pEvent type?))
						(== KEY_SHIFTTAB (pEvent message?))
					)
					(pEvent claimed: 1)
					(self retreat:)
				)
				(else (EditControl theItem pEvent))
			)
		)
		(return theTheItem)
	)
)

(class Controls of List
	(properties
		elements 0
		size 0
	)
	
	(method (draw)
		(self eachElementDo: #setSize)
		(self eachElementDo: #draw)
	)
	
	(method (handleEvent pEvent &tmp temp0)
		(if (pEvent claimed?) (return 0))
		(if
			(and
				(= temp0 (self firstTrue: #handleEvent pEvent))
				(not
					((= temp0 (self firstTrue: #handleEvent pEvent))
						checkState: 2
					)
				)
			)
			(temp0 doit:)
			(= temp0 0)
		)
		(return temp0)
	)
)
