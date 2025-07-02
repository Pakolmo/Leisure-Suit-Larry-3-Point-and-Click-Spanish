;;; Sierra Script 1.0 - (do not remove this comment)
(script# 620)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Follow)
(use Cycle)
(use Game)
(use Feature)

(public
	rm620 0
)

(instance rm620 of Rm
	(properties
		picture 620
		east 630
	)
	
	(method (init)
		(super init:)
		(gAddToPics
			add: atpKQsign
			add: atpNumbers
			add: atpSalesman1
			add: atpSalesman2
			add: atpSalesman3
			add: atpSalesman4
			add: atpTarget1
			add: atpTarget2
			add: atpTarget3
			add: atpTarget4
			add: atpTaxi
			add: atpTombstone
			add: atpCauldron
			add: atpClothes
			add: atpMonolithBurger
			doit:
		)
		(proc0_1)
		(gEgo posn: 12 188 init:)
		(proc0_2 aLarry 0)
		(aLarry
			view: 720
			posn: 12 184
			setMotion: Follow gEgo 28
			setCycle: Walk
			init:
			loop: 0
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(cond 
			((Said 'get/flat') (proc255_0 620 0))
			((Said 'get') (proc255_0 620 1))
			((Said 'look>')
				(cond 
					((Said '/prop') (proc255_0 620 2))
					((Said '/flat') (proc255_0 620 3))
					((Said '/couple,man') (proc255_0 620 4))
					((Said '/cauldron') (proc255_0 620 5))
					((Said '/number') (proc255_0 620 6))
					((Said '/cloth') (proc255_0 620 7))
					((Said '/gravestone') (proc255_0 620 8 30 1 67 10 -1 70 290))
					((Said '/awning,column') (proc255_0 620 9))
					((Said '/cab,auto') (proc255_0 620 10) (proc255_0 620 11 67 -1 144))
					((Said '[/backdrop,backstage,area]') (proc255_0 620 12))
				)
			)
			(
				(and
					(== (pEvent type?) evMOUSEBUTTON)
					(not (& (pEvent modifiers?) emSHIFT))
					(> (pEvent x?) 1)
					(< (pEvent x?) 319)
					(> (pEvent y?) 21)
					(< (pEvent y?) 189)
				)
				(pEvent claimed: 1)
				(switch gCursorNumber
					(998
						(proc255_0 610 3)
						(proc255_0 610 4 67 -1 144)
					)
					(else  (pEvent claimed: 0))
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gTheMusic fade:)
	)
)

(instance atpKQsign of PV
	(properties
		y 107
		x 122
		view 620
		priority 7
		signal $4000
	)
)

(instance atpNumbers of PV
	(properties
		y 164
		x 177
		view 620
		cel 1
		priority 12
	)
)

(instance atpSalesman1 of PV
	(properties
		y 134
		x 7
		view 620
		cel 2
		priority 9
	)
)

(instance atpSalesman2 of PV
	(properties
		y 142
		x 16
		view 620
		cel 2
		priority 10
	)
)

(instance atpSalesman3 of PV
	(properties
		y 151
		x 10
		view 620
		cel 2
		priority 11
	)
)

(instance atpSalesman4 of PV
	(properties
		y 156
		x 26
		view 620
		cel 2
		priority 11
	)
)

(instance atpTarget1 of PV
	(properties
		y 158
		x 238
		view 620
		loop 1
		priority 11
	)
)

(instance atpTarget2 of PV
	(properties
		y 161
		x 241
		view 620
		loop 1
		priority 12
	)
)

(instance atpTarget3 of PV
	(properties
		y 164
		x 245
		view 620
		loop 1
		priority 12
	)
)

(instance atpTarget4 of PV
	(properties
		y 116
		x 278
		view 620
		loop 1
		priority 8
	)
)

(instance atpTaxi of PV
	(properties
		y 189
		x 106
		view 620
		loop 1
		cel 1
		priority 14
	)
)

(instance atpTombstone of PV
	(properties
		y 97
		x 23
		view 620
		loop 1
		cel 2
		priority 6
	)
)

(instance atpCauldron of PV
	(properties
		y 128
		x 58
		view 620
		loop 1
		cel 3
		priority 9
	)
)

(instance atpClothes of PV
	(properties
		y 137
		x 185
		view 620
		loop 1
		cel 4
		priority 9
	)
)

(instance atpMonolithBurger of PV
	(properties
		y 156
		x 297
		view 620
		loop 2
		priority 11
	)
)

(instance aLarry of Act
	(properties)
)
