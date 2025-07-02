;;; Sierra Script 1.0 - (do not remove this comment)
(script# 290)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use TheMenuBar)

(public
	rm290 0
)

(local
	local0
)
(instance rm290 of Rm
	(properties
		picture 99
		style $0006
	)
	
	(method (init &tmp temp0 [temp1 9])
		(proc0_3)
		(= global97 0)
		(SL disable:)
		(TheMenuBar hide:)
		(super init:)
		(if (!= (= temp0 (FOpen {RESOURCE.LL3} 1)) -1)
			(= global88 (ReadNumber (FGets @temp1 8 temp0)))
		)
		(FClose temp0)
		(gEgo
			view: 290
			posn: 20 100
			setStep: 1 1
			setMotion: MoveTo 3000 100
			setCycle: Walk
			init:
		)
		(gGame setSpeed: 0)
	)
	
	(method (doit)
		(super doit:)
		(if (== (++ global87) 1) (= local0 (+ 60 (GetTime))))
		(if (< local0 (GetTime))
			(if global64
				(gGame setSpeed: 2)
			else
				(gGame setSpeed: 6)
			)
			(= global170
				(Format
					@global151
					290
					0
					(switch global88
						(4 {^Hijo de puta!})
						(3 {^Maldita sea!})
						(2 {^Maldici>n!})
						(1 {^Diablos!})
						(else  {^Caramba!})
					)
				)
			)
			(Format
				@global121
				290
				0
				(switch global88
					(4 {Totalmente obsceno})
					(3 {Realmente guarro})
					(2 {Bastante sucio})
					(1 {Algo arriesgado})
					(else  {Madre Ganso})
				)
			)
			(if (> (DoSound sndCHECK_DRIVER) 3)
				(= global72 -1)
			else
				(= global72 1)
			)
			(= global76 0)
			(= global172 5)
			(= global67 0)
			(= global68 0)
			(= global69 0)
			(= global110 20)
			(= global66 718)
			(= gGNumber_2 19)
			(= global82 (Format @global83 290 1))
			(proc0_20 4)
			(proc0_20 3)
			(TheMenuBar draw:)
			(SL enable:)
			(global2 newRoom: 200)
		)
	)
)
