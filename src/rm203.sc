;;; Sierra Script 1.0 - (do not remove this comment)
(script# 203)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use User)
(use Obj)

(public
	rm203 0
)

(local
	[local0 30]
	local30
)
(procedure (localproc_000c param1 param2 param3 param4 param5)
	(Display
		param5
		dsCOORD
		param1
		param2
		dsFONT
		param4
		dsCOLOR
		param3
	)
	(Display
		param5
		dsCOORD
		(+ param1 1)
		(+ param2 1)
		dsFONT
		param4
		dsCOLOR
		(- param3 8)
	)
)

(procedure (localproc_0043)
	(localproc_000c 54 105 local30 1 (Format @local0 203 4))
	(localproc_000c 90 120 local30 9 (Format @local0 203 5))
	(localproc_000c 56 140 local30 1 (Format @local0 203 6))
	(localproc_000c 49 155 local30 1 (Format @local0 203 7))
)

(instance rm203 of Rm
	(properties
		picture 203
	)
	
	(method (init)
		(super init:)
		(= gCursorNumber 998)
		(gGame setCursor: 998)
		(= gGGNumber_2 gGNumber_2)
		(= gGNumber_2 gNumber)
		(if (> (Graph grGET_COLOURS) 4)
			(= local30 14)
		else
			(= local30 7)
		)
		(User canControl: 1)
		(User canInput: 1)
		(self setScript: RoomScript)
		(localproc_0043)
		(User canInput: 0 mapKeyToDir: 0)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== (GameIsRestarting) 2) (localproc_0043))
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'look/away,area')
					(Said 'look<done,cease')
					(Said 'done,cease/look')
					(Said 'look<done,cease/awning')
					(Said 'exit,go,exit,done,cease')
				)
				(proc0_6)
				(= gGNumber_2 gGGNumber_2)
				(global2 newRoom: 200)
			)
			((Said 'look/awning') (proc255_0 203 0 67 10 5 70 290 30 1))
			((Said 'look/eye,head') (proc255_0 203 1))
			((Said 'look')
				(proc255_0 203 2)
				(if (not global108) (proc255_0 203 3))
			)
			((== (pEvent type?) evMOUSEBUTTON)
				(pEvent claimed: 1)
				(cond 
					((& (pEvent modifiers?) emSHIFT)
						(if (== gCursorNumber 998)
							(gGame setCursor: 991)
						else
							(gGame setCursor: 998)
						)
					)
					((== gCursorNumber 998)
						(proc255_0 203 2)
						(if (not global108) (proc255_0 203 3))
					)
					(else
						(proc0_6)
						(= gGNumber_2 gGGNumber_2)
						(gGame setCursor: 999)
						(global2 newRoom: 200)
					)
				)
			)
		)
	)
)
