;;; Sierra Script 1.0 - (do not remove this comment)
(script# 265)
(include sci.sh)
(use Main)
(use rm71)
(use Class_255_0)
(use Game)
(use InvI)
(use User)
(use Obj)

(public
	rm265 0
)
(synonyms
	(babe maller)
)

(local
	local0
)
(instance rm265 of Rm
	(properties
		picture 265
	)
	
	(method (init)
		(if (gEgo has: 1) (Load rsVIEW 1))
		(super init:)
		(self setRegions: 71 setLocales: 70 setScript: RoomScript)
		(proc0_13 71 1 115 77)
		(proc0_13 71 2 171 82)
		(proc0_13 71 3 114 82)
		(proc0_13 71 4 169 87)
		(proc0_13 71 5 139 121)
		(proc0_13 71 6 140 136)
		(= gCursorNumber 998)
		(gGame setCursor: 998)
		(gEgo get: 1)
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
			(1
				(proc0_3)
				(User canInput: 1 canControl: 1)
				(= gCursorNumber 997)
				(gGame setCursor: 997)
				(proc71_2 265 62 82 1 0 0)
				(gGame changeScore: 50)
				((Inv at: 1) owner: -1)
				(proc71_3 265 63)
				(= gGNumber_2 1)
				(++ state)
				(proc71_1 2 99)
				(= cycles 50)
			)
			(2
				(proc255_0 265 64)
				(proc71_1 2 55)
				(= cycles 20)
			)
			(3
				(global2 newRoom: 260)
				(= gCursorNumber 997)
				(gGame setCursor: 997)
			)
		)
	)
	
	(method (handleEvent pEvent &tmp gInvSaidMe)
		(if (pEvent claimed?) (return))
		(cond 
			(
				(or
					(Said 'go,get//center,shopping')
					(Said 'go,get/shopping,center')
				)
				(proc71_2 265 0)
				(proc71_3 265 1)
			)
			(
				(or
					(Said '(go<out),date/entertainer')
					(Said 'make/enjoy,date')
					(Said 'let<make/enjoy,date')
					(Said '/make/enjoy')
					(Said
						'ask,get,go/area,backdrop,comedian,club,date,exit,bar,show,building,dance'
					)
					(Said
						'ask,get,go//area,backdrop,comedian,club,date,exit,bar,show,building,dance'
					)
				)
				(proc71_2 265 2)
				(proc71_3 265 3)
			)
			((Said 'sell') (proc71_3 265 4) (proc71_1 2 20))
			((Said '/souvenir') (proc71_2 265 5) (proc71_3 265 6))
			((Said '/swim,bay,water') (proc71_2 265 7) (proc71_3 265 8))
			(
				(or
					(Said 'cease/look')
					(Said 'look<cease')
					(Said 'nightstand,(nightstand<up),(get<off,up)')
					(Said 'look/beach,area')
					(Said 'done,exit,exit,done,exit,go')
				)
				(self changeState: 2)
			)
			((Said 'bang') (proc71_3 265 9 global170) (proc71_1 4 8))
			((Said 'show/ball') (proc71_2 265 10) (proc71_3 265 11) (proc71_1 2 20))
			((Said '/weather') (proc71_3 265 12))
			((Said 'make/joke')
				(proc255_0 265 13)
				(proc255_0 265 14 67 -1 144)
				(proc71_3 265 15)
				(proc71_1 7 22)
			)
			((Said 'enjoy/ya') (proc71_2 265 16) (proc71_3 265 17) (proc71_1 5 44))
			(
				(or
					(Said '(out<go),dance,date/')
					(Said 'get/babe/building')
					(Said 'ask/babe/date')
					(Said
						'go/area,backdrop,comedian,club,date,exit,bar,show,dance'
					)
				)
				(proc71_2 265 18)
				(proc71_3 265 19)
			)
			((Said '/center') (proc71_2 265 20) (proc71_3 265 21))
			((Said 'address')
				(switch (Random 1 3)
					(1
						(proc71_2 265 22)
						(proc71_3 265 23)
					)
					(2
						(proc71_2 265 24)
						(proc71_3 265 25)
					)
					(else 
						(proc71_2 265 26)
						(proc71_3 265 27)
					)
				)
			)
			((Said 'look>')
				(cond 
					((Said '/calf') (proc255_0 265 28) (proc71_3 265 29) (proc71_1 3 22))
					((Said '/skin') (proc255_0 265 30) (proc255_0 265 31 67 -1 144))
					((Said '/boob')
						(if (>= global88 3)
							(proc255_0 265 32)
							(proc71_3 265 33)
						else
							(proc255_0 265 34)
							(proc71_3 265 35)
						)
						(proc71_1 6 12)
					)
					((Said '/eye') (proc255_0 265 36))
					((Said '/nose') (proc255_0 265 37))
					((Said '/ear') (proc255_0 265 38) (proc255_0 265 39 67 -1 144))
					((Said '/lip') (proc255_0 265 40))
					((Said '/dicklicker') (proc255_0 265 41))
					((Said '/eye') (proc255_0 265 42))
					((Said '/hair') (proc255_0 265 43))
					((Said '/ass,bottom') (proc255_0 265 44))
					((Said '/clit') (proc255_0 265 45) (proc71_3 265 46) (proc71_1 6 12))
					((Said '[/area,beach,babe]')
						(proc255_0 265 47)
						(proc255_0 265 48 67 -1 144)
						(proc71_1 2 33)
					)
				)
			)
			((Said 'show>')
				(= gInvSaidMe (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((Said '[/!*]') (proc255_0 265 49))
					(
					(or (not gInvSaidMe) (not (gInvSaidMe ownedBy: gEgo))) (proc0_12))
					((== gInvSaidMe (gInv at: 3)) (proc71_3 265 50) (proc71_1 4))
					((== gInvSaidMe (gInv at: 5)) (proc71_3 265 51) (proc71_1 4))
					((== gInvSaidMe (gInv at: 11)) (proc71_3 265 52) (proc71_1 4))
					((== gInvSaidMe (gInv at: 1)) (proc71_3 265 53))
					(else (proc71_3 265 54))
				)
				(pEvent claimed: 1)
			)
			((Said 'give>')
				(= gInvSaidMe (gInv saidMe:))
				(pEvent claimed: 0)
				(cond 
					((Said '[/!*]') (proc255_0 265 55))
					((not gInvSaidMe) (proc255_0 265 56))
					((not (gInvSaidMe ownedBy: gEgo)) (proc0_12))
					((== gInvSaidMe (gInv at: 3)) (proc71_3 265 57) (proc71_1 4))
					((== gInvSaidMe (gInv at: 5)) (proc71_3 265 58) (proc71_1 4))
					((== gInvSaidMe (gInv at: 11)) (proc71_3 265 59) (proc71_1 4))
					((== gInvSaidMe (gInv at: 1))
						(if (not (gEgo has: 1))
							(proc0_12)
						else
							(self changeState: 1)
						)
					)
					(else (proc71_3 265 60))
				)
				(pEvent claimed: 1)
			)
			((Said 'get') (proc71_3 265 61) (proc71_1 2 22))
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
					(if (== gCursorNumber 995)
						(gGame setCursor: 995 (HaveMouse))
					)
					(if
						(and
							(or
								(proc0_27 99 132 65 88 pEvent)
								(proc0_27 153 195 75 90 pEvent)
							)
							(== gCursorNumber 998)
						)
						(proc255_0 265 36)
						(pEvent claimed: 1)
					)
					(if
						(and
							(proc0_27 126 153 77 117 pEvent)
							(== gCursorNumber 998)
						)
						(proc255_0 265 37)
						(pEvent claimed: 1)
					)
					(if
						(and
							(proc0_27 72 86 74 104 pEvent)
							(== gCursorNumber 998)
						)
						(proc255_0 265 38)
						(proc255_0 265 39 67 -1 144)
						(pEvent claimed: 1)
					)
					(if (proc0_27 118 165 128 142 pEvent)
						(switch gCursorNumber
							(998
								(proc255_0 265 40)
								(pEvent claimed: 1)
							)
							(996
								(switch (Random 1 3)
									(1
										(proc71_2 265 22)
										(proc71_3 265 23)
									)
									(2
										(proc71_2 265 24)
										(proc71_3 265 25)
									)
									(3
										(proc71_2 265 26)
										(proc71_3 265 27)
									)
								)
								(pEvent claimed: 1)
							)
						)
					)
					(if
						(or
							(proc0_27 57 231 21 59 pEvent)
							(proc0_27 241 219 21 185 pEvent)
						)
						(switch gCursorNumber
							(998
								(proc255_0 265 43)
								(pEvent claimed: 1)
							)
						)
					)
					(if
						(and
							(proc0_27 55 240 20 190 pEvent)
							(== (pEvent claimed?) 0)
						)
						(switch gCursorNumber
							(999 (pEvent claimed: 1))
							(998
								(proc255_0 265 47)
								(proc255_0 265 48 67 -1 144)
								(proc71_1 2 33)
								(pEvent claimed: 1)
							)
							(995
								(proc71_3 265 61)
								(proc71_1 2 22)
								(pEvent claimed: 1)
								(gGame setCursor: 995 (HaveMouse))
							)
							(996
								(switch (Random 1 3)
									(1
										(proc71_2 265 22)
										(proc71_3 265 23)
									)
									(2
										(proc71_2 265 24)
										(proc71_3 265 25)
									)
									(3
										(proc71_2 265 26)
										(proc71_3 265 27)
									)
								)
								(pEvent claimed: 1)
							)
							(3
								(proc71_3 265 57)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(5
								(proc71_3 265 58)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(9
								(proc71_3 265 59)
								(proc71_1 4)
								(pEvent claimed: 1)
							)
							(1
								(if (not (gEgo has: 1))
									(proc0_12)
									(pEvent claimed: 1)
								else
									(= gGCursorNumber 900)
									(gGame setCursor: 997 (HaveMouse))
									(proc0_3)
									(gGame setCursor: 997 (HaveMouse))
									(self changeState: 1)
									(gGame setCursor: 997 (HaveMouse))
								)
							)
							(991
								(proc0_3)
								(self changeState: 2)
								(pEvent claimed: 1)
							)
							(else 
								(proc71_3 265 60)
								(pEvent claimed: 1)
							)
						)
					)
					(if
						(and
							(proc0_27 0 320 21 190 pEvent)
							(== (pEvent claimed?) 0)
						)
						(switch gCursorNumber
							(995 (pEvent claimed: 1))
							(999 (pEvent claimed: 1))
							(991
								(self changeState: 2)
								(pEvent claimed: 1)
							)
							(else 
								(gGame setCursor: 991 (HaveMouse))
								(pEvent claimed: 1)
							)
						)
					)
				)
			)
		)
	)
)
