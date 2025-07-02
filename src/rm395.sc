;;; Sierra Script 1.0 - (do not remove this comment)
(script# 395)
(include sci.sh)
(use Main)
(use rm71)
(use Class_255_0)
(use Game)
(use User)
(use Obj)

(public
	rm395 0
)
(synonyms
	(babe bambi)
)

(local
	local0
	[local1 55]
)
(instance rm395 of Rm
	(properties
		picture 395
	)
	
	(method (init)
		(super init:)
		(User canInput: 0 mapKeyToDir: 0)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript)
		(proc0_13 71 1 111 47)
		(proc0_13 71 2 174 85)
		(proc0_13 71 3 98 60)
		(proc0_13 71 4 165 96)
		(proc0_13 71 5 93 104)
		(proc0_13 71 6 90 111)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(self dispose: 71)
	)
)

(instance RoomScript of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0)
			(7
				(proc0_3)
				(proc71_2 395 53)
				(proc71_3 395 54)
				(proc71_1 2 22)
				(= cycles 22)
			)
			(8
				(gGame changeScore: 99)
				(proc71_2 395 55)
				(proc71_3 395 56)
				(proc71_1 2 22)
				(= cycles 22)
			)
			(9
				(proc71_2 395 57)
				(proc71_3 395 58)
				(proc71_1 2 22)
				(= cycles 22)
				(gTheMusic fade:)
			)
			(10
				(= gGNumber_2 1)
				(gTheMusic stop:)
				(global2 newRoom: 390)
			)
			(11
				(proc71_2 395 59)
				(proc71_3 395 60)
				(proc71_1 2 33)
				(= cycles 22)
			)
			(12 (global2 newRoom: 390))
		)
	)
	
	(method (handleEvent pEvent &tmp gInvSaidMe)
		(if
			(and
				(not (super handleEvent: pEvent))
				(not (pEvent claimed?))
				gTheNewDialog
				(or
					(and
						(== (pEvent message?) KEY_RETURN)
						(== (pEvent type?) evKEYBOARD)
					)
					(== (pEvent type?) evMOUSEBUTTON)
				)
			)
			(pEvent claimed: 1)
			(proc0_5)
			(self cue:)
		)
		(if (pEvent claimed?) (return))
		(cond 
			((== (pEvent type?) evMOUSEBUTTON)
				(if (& (pEvent modifiers?) emSHIFT)
					(switch gCursorNumber
						(gGCursorNumber
							(gGame setCursor: 991 (HaveMouse))
							(pEvent claimed: 1)
						)
						(991
							(gGame setCursor: 998 (HaveMouse))
							(pEvent claimed: 1)
						)
						(999
							(gGame setCursor: 998 (HaveMouse))
							(pEvent claimed: 1)
						)
						(993
							(gGame setCursor: 996 (HaveMouse))
							(pEvent claimed: 1)
						)
						(996
							(gGame setCursor: 994 (HaveMouse))
							(pEvent claimed: 1)
						)
						(998
							(gGame setCursor: 995 (HaveMouse))
							(pEvent claimed: 1)
						)
						(995
							(gGame setCursor: 996 (HaveMouse))
							(pEvent claimed: 1)
						)
						(994
							(if
								(or
									(== gGCursorNumber 900)
									(== gGCursorNumber 994)
									(== gGCursorNumber 666)
									(== gGCursorNumber 992)
									(== gGCursorNumber 993)
								)
								(gGame setCursor: 991 (HaveMouse))
							else
								(gGame setCursor: gGCursorNumber (HaveMouse))
								(= gCursorNumber gGCursorNumber)
							)
							(pEvent claimed: 1)
						)
					)
				else
					(if (== gCursorNumber 999)
						(gGame setCursor: 998 (HaveMouse))
					)
					(if (proc0_27 1 319 21 190 pEvent)
						(switch gCursorNumber
							(998
								(proc255_0 395 51)
								(proc71_3 395 52)
								(proc71_1 2 33)
								(pEvent claimed: 1)
							)
							(9
								(proc71_3 395 2)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(5
								(proc71_3 395 3)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(10
								(proc71_2 395 4)
								(proc71_3 395 5)
								(proc71_1 4 6)
								(pEvent claimed: 1)
							)
							(2
								(proc71_3 395 6)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(11
								(proc71_3 395 7)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(8
								(proc71_3 395 8)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(994
								(proc255_0 395 49)
								(proc71_3 395 50)
								(proc71_1 6 12)
								(pEvent claimed: 1)
							)
							(996
								(proc71_2 395 16)
								(proc71_3 395 17)
								(proc71_1 4 11)
								(if (not global118)
									(proc71_2 395 12)
									(proc71_3 395 13)
									(proc71_1 4 22)
								else
									(self changeState: 7)
								)
								(pEvent claimed: 1)
							)
							(991
								(proc0_3)
								(gGame setCursor: 999 (HaveMouse))
								(self changeState: 11)
								(pEvent claimed: 1)
							)
							(else  (pEvent claimed: 0))
						)
					)
				)
			)
			((Said 'give>')
				(= gInvSaidMe (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((Said '[/!*]') (proc255_0 395 0))
					((not gInvSaidMe) (proc255_0 395 1))
					((not (gInvSaidMe ownedBy: gEgo)) (proc0_12))
					((== gInvSaidMe (gInv at: 9)) (proc71_3 395 2) (proc71_1 4))
					((== gInvSaidMe (gInv at: 5)) (proc71_3 395 3) (proc71_1 4))
					((== gInvSaidMe (gInv at: 10)) (proc71_2 395 4) (proc71_3 395 5) (proc71_1 4 6))
					((== gInvSaidMe (gInv at: 2)) (proc71_3 395 6) (proc71_1 4))
					((== gInvSaidMe (gInv at: 11)) (proc71_3 395 7) (proc71_1 4))
					((== gInvSaidMe (gInv at: 8)) (proc71_3 395 8) (proc71_1 4))
					(else (proc71_3 395 9) (proc71_1 4))
				)
				(pEvent claimed: 1)
			)
			((Said 'bang') (proc255_0 395 10) (proc71_3 395 11) (proc71_1 4 4))
			((or (Said 'aid//tape') (Said 'aid/tape'))
				(if (not global118)
					(proc71_2 395 12)
					(proc71_3 395 13)
					(proc71_1 4 22)
				else
					(self changeState: 7)
				)
			)
			(
			(or (Said 'aid') (Said '/aid') (Said '//aid'))
				(if (Random 0 1)
					(proc255_0 395 14)
				else
					(proc255_0 395 15)
				)
			)
			((or (Said 'ask//tape') (Said 'ask/tape')) (proc71_2 395 16) (proc71_3 395 17) (proc71_1 4 11))
			(
				(or
					(Said 'class,(work<out)')
					(Said '/class,class,(work<out)')
					(Said '//class,class,(work<out)')
				)
				(proc71_2 395 18)
				(proc71_3 395 19)
				(proc71_1 4 4)
			)
			(
				(or
					(Said '/tan,booth,booth')
					(Said '//tan,booth,booth')
				)
				(proc71_2 395 20)
				(proc71_3 395 21)
			)
			((or (Said '/attendant') (Said '//attendant')) (proc71_2 395 22) (proc71_3 395 23) (proc71_1 6 5))
			((Said 'show/ball') (proc71_2 395 24) (proc71_3 395 25) (proc71_1 2 20))
			((Said 'make/joke')
				(proc71_2 395 26)
				(proc71_2 395 27 67 -1 144)
				(proc71_3 395 28)
				(proc71_1 7 22)
			)
			(
				(or
					(Said '(out<go),dance,show,date/')
					(Said 'get/babe/building')
					(Said
						'ask,go//area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
					(Said
						'ask,go/area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
				)
				(proc71_2 395 29)
				(proc71_3 395 30)
				(proc71_1 4 11)
			)
			((Said '/equipment,camera,camera') (proc71_2 395 31) (proc71_3 395 32) (proc71_1 2 20))
			((Said 'address/babe')
				(cond 
					((not global118)
						(proc71_2 (Format @local1 395 33 global171))
						(proc71_3 395 34)
					)
					((proc0_22 8)
						(proc255_4 395 33 global171)
						(proc71_3 395 35)
						(proc71_1 4 11)
					)
					((proc0_22 10)
						(proc255_4 395 33 global171)
						(proc71_3 395 36)
						(proc71_1 4 11)
					)
					((proc0_22 62)
						(proc255_4 395 33 global171)
						(proc71_3 395 37)
						(proc71_1 4 11)
					)
					(else
						(proc71_1 2 20)
						(switch (++ local0)
							(1
								(proc71_2 395 38)
								(proc71_3 395 32)
							)
							(2
								(proc71_2 395 39)
								(proc71_3 395 17)
							)
							(else 
								(proc71_2 395 40)
								(proc71_3 395 41)
							)
						)
					)
				)
			)
			((or (Said 'enjoy/ya') (Said '/enjoy/ya')) (proc71_2 395 42) (proc71_3 395 43) (proc71_1 5 44))
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'look/area')
					(Said 'done,exit,exit,done,exit,go')
					(Said 'nightstand,(nightstand<up),(get<off,up)')
				)
				(self changeState: 11)
			)
			((Said 'look>')
				(cond 
					((Said '/calf') (proc71_3 395 44) (proc71_1 3 22))
					((Said '/bracelet') (proc255_0 395 45))
					((Said '/ear') (proc255_0 395 46))
					((or (Said '/tape') (Said '//tape')) (proc71_2 395 47) (proc71_3 395 48))
					((Said '/boob') (proc255_0 395 49) (proc71_3 395 50) (proc71_1 6 12))
					((Said '[/area,babe]') (proc255_0 395 51) (proc71_3 395 52) (proc71_1 2 33))
				)
			)
		)
	)
)
