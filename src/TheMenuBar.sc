;;; Sierra Script 1.0 - (do not remove this comment)
(script# 997)
(include sci.sh)
(use Class_255_0)

(public
	proc997_1 1
)

(local
	local0
)
(procedure (proc997_1 &tmp temp0)
	(= temp0 (DoSound sndSET_SOUND))
	(DoSound sndSET_SOUND (not temp0))
	(if temp0
		(SetMenu 1282 110 {Turn On})
	else
		(SetMenu 1282 110 {Turn Off})
	)
)

(class TheMenuBar of Class_255_0
	(properties
		state $0000
	)
	
	(method (init)
		(AddMenu { \01_} {About Template`^a:})
	)
	
	(method (handleEvent pEvent &tmp [temp0 224])
		(super handleEvent: pEvent)
		(switch pEvent
			(257
				(proc255_0 {PnC Template Game} 80 {About})
			)
		)
	)
)
