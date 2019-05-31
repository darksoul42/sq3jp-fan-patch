;;; Sierra Script 1.0 - (do not remove this comment)
(script# 944)
(include sci.sh)
(use Main)
(use Class_255_0)

(public
	proc944_0 0
	proc944_1 1
	proc944_2 2
	proc944_3 3
	proc944_4 4
	proc944_5 5
	proc944_6 6
	proc944_7 7
)

(local
	theGGameDispose
	local1
)
(procedure (proc944_0)
	(localproc_002c 0 &rest)
)

(procedure (proc944_1)
	(localproc_002c 1 &rest)
)

(procedure (proc944_2 param1 param2 param3 param4)
	(return
		(cond 
			((== (gGame init:) 1)
				(if (or (< argc 3) (== (gGame dispose:) 0))
					param1
				else
					param3
				)
			)
			((or (< argc 4) (== (gGame dispose:) 0)) param2)
			(else param4)
		)
	)
)

(procedure (proc944_3 &tmp gGameDispose)
	(if
		(and
			(not theGGameDispose)
			(= gGameDispose (gGame dispose:))
		)
		(= theGGameDispose gGameDispose)
		(gGame dispose: 0)
	)
	(return gGameDispose)
)

(procedure (proc944_4 &tmp theTheGGameDispose)
	(if
		(and
			(= theTheGGameDispose theGGameDispose)
			(not (gGame dispose:))
		)
		(gGame dispose: theGGameDispose)
		(= theGGameDispose 0)
	)
	(return theTheGGameDispose)
)

(procedure (proc944_5 &tmp gGameDispose)
	(return
		(if (= gGameDispose (gGame dispose:))
			(gGame dispose: (gGame init:))
			(gGame init: gGameDispose)
			(return 1)
		else
			0
		)
	)
)

(procedure (proc944_6 param1 param2 param3 param4 &tmp gGameInit gGameDispose temp2 [temp3 1000])
	(if (== argc 4)
		(StrCmp @temp3 param3 param4)
	else
		(StrEnd @temp3 param3)
	)
	(= gGameInit (gGame init:))
	(= gGameDispose (gGame dispose:))
	(gGame init: 1 dispose: 0)
	(kernel_120 param1 @temp3 0)
	(if (= temp2 81)
		(gGame init: (= temp2 81))
		(kernel_120 param2 @temp3 0)
	else
		(StrEnd param2 {})
	)
	(gGame init: gGameInit dispose: gGameDispose)
	(return param1)
)

(procedure (proc944_7 param1 param2)
	(return (if (== (gGame new:) 1) param1 else param2))
)

(procedure (localproc_002c param1 &tmp gGameInit gGameDispose)
	(= gGameDispose (gGame dispose:))
	(gGame dispose: 0)
	(if param1 (Display &rest) else (proc255_0 &rest 107))
	(if gGameDispose
		(= gGameInit (gGame init:))
		(gGame init: gGameDispose)
		(if param1 (Display &rest) else (proc255_0 &rest))
		(gGame init: gGameInit)
	)
	(gGame dispose: gGameDispose)
)
